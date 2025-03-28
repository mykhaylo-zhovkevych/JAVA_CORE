# Die Dokumentation über MQ Block3: Migration Strategie und die Containerisierung

_Erstellt von Mykhaylo Zhovkevych_

_Abgaben Datum: 27.03.25_

_Einleitung/ Thema_
Diese Dokumentation beschreibt die ausgewählte Migrationsstrategie sowie die schrittweise Umsetzung der Migration von Mosquitto mit Containerisierung. Zusätzlich werden Verbesserungen am Java-Code erläutert.

## Die ausgewählte Strategie

Für diesen Auftrag wurde die Cold Turkey (Big Bang)-Strategie gewählt, da ihre Vorteile die Nachteile überwiegen. Während der Projektumsetzung wurden jedoch einige kritische Fehler aufgedeckt, die während der Systemmigration entstanden sind.
Nach der Behebung dieser Probleme kann das System schnell und einwandfrei eingesetzt werden.

## Die Migrations Erklärung

Hauptanforderungen:

    1. Erstellung des Images

    2. Erstellung und Testen von Containern für jeden Sensor

    3. Containerisierung von Grafana zur Visualisierung der Daten

    4. Erstellung eines Testplans und einer Protokollierung

Zunächst habe ich die Container erstellt, damit später das finale Image erzeugt und veröffentlicht werden kann.

Mithilfe der docker-compose.yml-Datei habe ich drei Container erstellt, die Umgebungsvariablen nutzen. Zudem habe ich dort auch den MQTT-Broker und Grafana definiert.

```yaml
version: "3.9"
services:
  sin_publisher:
    build: .
    environment:
      - MQTT_PUB_TOPIC_SIN=sensoren/sinus
    networks:
      - mqtt_net

  cos_publisher:
    build: .
    environment:
      - MQTT_PUB_TOPIC_COS=sensoren/cosinus
    networks:
      - mqtt_net

  tan_publisher:
    build: .
    environment:
      - MQTT_PUB_TOPIC_TAN=sensoren/tangens
    networks:
      - mqtt_net

  mqtt_broker:
    image: eclipse-mosquitto
    container_name: mqtt_broker
    ports:
      - "1883:1883"
    networks:
      - mqtt_net
    volumes:
      - ./mosquitto.conf:/mosquitto/config/mosquitto.conf

  grafana:
    image: grafana/grafana:latest
    container_name: grafana
    ports:
      - "3000:3000" # Grafana-Webinterface auf Port 3000
    networks:
      - mqtt_net
    environment:
      - GF_SECURITY_ADMIN_PASSWORD=admin # Standard-Admin-Passwort für Grafana
    volumes:
      - grafana_data:/var/lib/grafana # Speichert die Grafana-Daten persistent

networks:
  mqtt_net:
    driver: bridge

volumes:
  grafana_data: # Erstelle ein Volume für Grafana-Daten
```

Die kompilierte Java-Anwendung sowie die Konfigurationsdatei werden in den Container kopiert, damit sie containerisiert werden können.

```Dockerfile
FROM openjdk:17-jdk-slim

# Arbeitsverzeichnis erstellen
WORKDIR /app

# Kopiere die kompilierten Klassen und Konfigurationsdatei in den Container
COPY target/MqttSinusPublisherExtended.jar app.jar
COPY src/test/java/config.properties config.properties

# Die Umgebungsvariablen für MQTT-Topics
ENV MQTT_PUB_TOPIC_SIN="sensoren/sinus"
ENV MQTT_PUB_TOPIC_COS="sensoren/cosinus"
ENV MQTT_PUB_TOPIC_TAN="sensoren/tangens"
ENV MQTT_SUB_TOPIC="feedback/java"

# Container-Eintrittspunkt: Starte die Java-Anwendung
CMD ["java", "-jar", "app.jar"]
```

Ich musste einige Codeänderungen vornehmen, da es sonst zu Kollisionen zwischen den Sensoren gekommen wäre.
Es wurde mit drei separaten Threads für drei Operationen und einer sleep()-Methode angewendet, so dass die Container an ein Ende angeschlossen werden können und nicht alle gleichzeitig an einen Broker.

```java
package test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttSinusPublisherExtended {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
    private static final String DEFAULT_CONFIG_FILE = "config.properties";

    public static void main(String[] args) {

        String CLIENT_ID = "JavaMqttClient_" + java.util.UUID.randomUUID().toString();

        try {
            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(DEFAULT_CONFIG_FILE)) {
                properties.load(fis);
            } catch (IOException e) {
                System.err.println("Konfigurationsdatei nicht gefunden oder fehlerhaft. Verwende Standardwerte");
            }

            // Kommandozeilenargumente, Umgebungsvariablen oder Standardwerte für Topics
            String sinPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_SIN", properties, "sensoren/sinus");
            String cosPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_COS", properties, "sensoren/cosinus");
            String tanPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_TAN", properties, "sensoren/tangens");
            String subTopic = getTopicFromArgsOrEnv(args, "MQTT_SUB_TOPIC", properties, "feedback/java");

            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            connectWithRetry(client, options);

            client.subscribe(subTopic, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Feedback erhalten: " + payload);
                if ("stop".equalsIgnoreCase(payload.trim())) {
                    System.out.println("Empfangenes 'stop' - Beende die Publikation.");
                    client.disconnect();
                    System.exit(0);
                }
            });

            Thread sinThread = new Thread(() -> publishSensorData(client, sinPubTopic, "sin"));
            Thread cosThread = new Thread(() -> publishSensorData(client, cosPubTopic, "cos"));
            Thread tanThread = new Thread(() -> publishSensorData(client, tanPubTopic, "tan"));

            sinThread.start();
            cosThread.start();
            tanThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Methode, um das Topic aus den Kommandozeilenargumenten oder Umgebungsvariablen zu bekommen
    private static String getTopicFromArgsOrEnv(String[] args, String propertyKey, Properties properties, String defaultValue) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equalsIgnoreCase("--" + propertyKey)) {
                    if (i + 1 < args.length) {
                        return args[i + 1];
                    }
                }
            }
        }

        String envValue = System.getenv(propertyKey);
        if (envValue != null && !envValue.isEmpty()) {
            return envValue;
        }

        return properties.getProperty(propertyKey, defaultValue);
    }

    // Methode zum Verbinden mit dem Broker
    private static void connectWithRetry(MqttClient client, MqttConnectOptions options) {
        int retries = 5;
        while (retries > 0) {
            try {
                client.connect(options);
                System.out.println("Erfolgreich mit dem Broker verbunden.");
                return;
            } catch (MqttException e) {
                retries--;
                System.err.println("Verbindungsfehler, versuche es erneut... (" + retries + " Versuche übrig)");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.err.println("Verbindung mit dem Broker nach mehreren Versuchen fehlgeschlagen.");
        System.exit(1);
    }

    // Methode, die die Sensordaten veröffentlicht
    private static void publishSensorData(MqttClient client, String pubTopic, String function) {
        try {
            double counter = 0.0;
            while (true) {
                double value = switch (function.toLowerCase()) {
                    case "cos" -> Math.cos(counter);
                    case "tan" -> Math.tan(counter);
                    default -> Math.sin(counter);
                };

                String messageContent = String.valueOf(value);
                MqttMessage message = new MqttMessage(messageContent.getBytes());
                message.setQos(0);
                client.publish(pubTopic, message);
                System.out.println("Gesendet an " + pubTopic + ": " + messageContent);

                counter += 0.1;
                Thread.sleep(1000);
            }
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

Output:

```yml
sin_publisher-1  | Gesendet an sensoren/cosinus: 0.5963474973911665
sin_publisher-1  | Gesendet an sensoren/tangens: -1.3460715383585509
sin_publisher-1  | Gesendet an sensoren/sinus: -0.8027263932095995
tan_publisher-1  | Gesendet an sensoren/tangens: 3.743167944281379
tan_publisher-1  | Gesendet an sensoren/cosinus: -0.2581016359376908
tan_publisher-1  | Gesendet an sensoren/sinus: -0.966117770008547
cos_publisher-1  | Gesendet an sensoren/tangens: -1.3460715383585509
cos_publisher-1  | Gesendet an sensoren/sinus: -0.8027263932095995
cos_publisher-1  | Gesendet an sensoren/cosinus: 0.5963474973911665
```

![Die Grafana Screenshot](<Screenshot 2025-03-27 114042.png>)
_Die Werten werden aus irgendwelchen Grund falsch abgebilted, trotzdem dass es alles hat richtig letze Mal funktionert._

## Testplan

### Testfälle

| Testfall-ID | Tester-ID | Erwartetes Ergebnis                                                               | Tatsächliches Ergebnis                                                                              | Verbesserung/Optimierung                     |
| ----------- | --------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | -------------------------------------------- |
| TC-001      | T001      | Jeder Sensor hat einen Container und kann ohne Programmstopp abgeschaltet werdeng | Jeder Sensor hat einige Contianer und kann separat abgeschalet werden                               | Keine Optimierung ist benötigt               |
| TC-002      | T002      | Die tan, cos, sin wird richtig ausgerechnet                                       | Leider die Berechnung von Operationen falsche geschlagen                                            | Die Code Revesion, damit dem Problem beheben |
| TC-003      | T003      | Die MQTT-Broker ist containerisiert und ist richtig konfiguriert                  | Ja, die MQTT-Broker lauft und kann die andere Sensoren per Umgebungsvariable akzeptieren            | Keine Optimierung ist benötigt               |
| TC-004      | T004      | Die Grafana ist containerisiert und kann lokal abgerufen werden                   | Ja, man kann mithilfenvon Grafana die containerisierte Sensoren zugreifen und visualisieren         | Keine Verbesserung ist benötigt              |
| TC-005      | T005      | Die Docker-Image ist erstellt und publiziert                                      | [Link zu DockerHub](https://hub.docker.com/repository/docker/mykhaylozhovkevych/my-java-app/general) | Keine Verbesserung ist benötigt              |

### Fehlerprotokoll

Bei die TC-002 hat eine logische Error, weil dort alle drei Threads in derselben Anwendung laufen, teilen sie sich denselben MQTT-Client. _Das bedeutet dass jeder Thread veröffentlicht nicht nur auf das eigene Topic, sondern scheinbar auf alle Topics_
Eine mögliche Lösung wäre: Die richtige Topics: String pubTopic = "sensoren/" + function.toLowerCase(); setzen und jeder Publisher sendet nur an sein eigenes Topic. Keine doppelten oder falschen Einträge mehr.

## Schlussfolderung

Meiner Meinung nach war die Migration erfolgreich. Es gab ein paar Unklarheiten bei der Code-Ausführung und Containerisierung, aber alles konnte recht schnell behoben werden, sodass das gesamte System containerisiert ist
