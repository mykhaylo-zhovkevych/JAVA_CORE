## Die Dokumentation über MQ Block3: MQTT mit Java

*Erstellt von Mykhaylo Zhovkevych*

*Abgaben Datum: 10.03.24*


*Einleitung/ Thema*
Es soll die zwei Aufgabenstellungen gelöst werden:


Aufgabestellung 03A:
- Studiere zunächst die folgende Webseite: [https://www.emqx.com/en/blog/how-to-use-mqtt-in-java](https://www.emqx.com/en/blog/how-to-use-mqtt-in-java)
- Erstelle ein Java-Projekt (z.B. mit Eclipse) und binde die Apache-Paho MQTT-Library ein.
- Erstelle eine Java-Klasse mit folgenden Verhalten:
	- alle 1 Sekunden berechnest du den Sinus-Wert einer Zählervariable
	- gib den berechneten Wert auf der Konsole aus
	- der Sinux-Wert wird unter dem Topic sensoren/java1 den MQTT-Broker publiziert
	- nach jedem Publizieren wird die Zählervariable um 0.1 erhöht
	- du kannst alle Funktionalität in der public static void main(String[] args) programmieren
	- Prüfe mit Grafana oder einem Terminal, ob die Nachrichten korrekt am Broker ankommen.
	- Erweitere deine Java-Klasse um folgendes Verhalten:
	- abonniere ausserhalb der Schleife das Topic "feedback/java1"
	- gib die empfangenen Nachrichten auf der Konsole aus
	- wenn die Zeichenkette stop empfangen wird, sollen keine weiteren Sinus-Werte gesendet werden.
	- Teste die korrekte Funktionalität deines Java-Programms, indem du die Daten z.B. mit Grafana visualisierst. Das Ergebnis könnte so aussehen:



Aufgabestellung 03B:
-  Erweitere deine Java-Klasse so, dass PUB und SUB-Topics per Kommandozeile oder Umgebungsvariable übergeben werden.
-  Teste die korrekte Funktionalität deines Java-Programms, indem du mit einem zeitlichen Abstand in mehreren Terminals Java-Sensoren mit unterschiedlichen PUB-Topics startest.
- Die Daten visualisierst du z.B. mit Grafana. Das Ergebnis könnte z.B. so aussehen:




Aufgabestellung03A:

``` java
package test.java;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

// mosquitto_sub -h broker.hivemq.com -t "sensoren/java1"

public class MqttSinusPublisher {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
    // private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String TOPIC_PUBLISH = "sensoren/java1";
    private static final String TOPIC_SUBSCRIBE = "feedback/java1";
    private static final String CLIENT_ID = "JavaMqttClient";
    
    public static void main(String[] args) {
        try {
            // Eine Instanz des MQTT-Clients
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
            /* 
             * Warum MqttConnectOptions einsetzen? und nicht einfach client.connect()? 
             * Es erzeugt ein neues Objekt der Klasse MqttConnectOptions und setzt die
             * Eigenschaft cleanSession auf true. Das bedeutet, dass der Broker alle
             * Informationen über den Client löscht, wenn die Verbindung getrennt wird.
             */
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            client.connect(options);
            // Abonniere das Feedback-Topic
            // Lambda-Ausdruck wird aufgerufen, wenn eine Nachricht eingeht
            client.subscribe(TOPIC_SUBSCRIBE, (topic, message) -> {
                // Holt die empfangenen Daten als byte[]-Array und konvertiert es in einen String
                String payload = new String(message.getPayload());
                System.out.println("Feedback erhalten: " + payload);
                // Break Condition
                if ("stop".equalsIgnoreCase(payload.trim())) {
                    System.out.println("Empfangenes 'stop' - Beende die Publikation.");
                    client.disconnect();
                    System.exit(0);
                }
            });
            double counter = 0.0;
            while (true) {
                /* Warum diese Konvertierung is benötigt?
                 * Weil die MQTT erwartet, eine Nachricht als byte[]-Array zu empfangen
                 * Und Die double wird zu String und String zu byte[]-Array konvertiert
                 */
                double sinusValue = Math.sin(counter);
                // Wandelt den Sinuswert in einen String um.
                String messageContent = String.valueOf(sinusValue);
                // Konvertiert den String in ein Byte-Array und erstellt ein MqttMessage-Objekt
                MqttMessage message = new MqttMessage(messageContent.getBytes());
                // Die Nachricht wird maximal einmal gesendet (keine Wiederholung bei Verbindungsverlust)
                message.setQos(0);
                // Sendet die Nachricht an sensoren/java1
                client.publish(TOPIC_PUBLISH, message);
                System.out.println("Gesendet: " + messageContent);
                counter += 0.1;
                Thread.sleep(1000); // 1 Sekunde warten
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
Dann wenn ich ausführe diese Befehl: ` PS C:\Program Files\mosquitto> .\mosquitto_pub -h broker.hivemq.com -t "feedback/java1" -m "stop" `
wird das Programm es erkennen und  das Programm stoppen.

![alt text](<Screenshot 2025-03-06 195904.png>)
	"Diese Bild zeigt eine Visualisierung von Sinus"


Aufgabestellung 03B:

``` java
package test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MqttSinusPublisherExtended {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
    private static final String DEFAULT_CONFIG_FILE = "config.properties";
    private static final String CLIENT_ID = "JavaMqttClient";

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(DEFAULT_CONFIG_FILE)) {
                properties.load(fis);
            } catch (IOException e) {
                System.err.println("Konfigurationsdatei nicht gefunden oder fehlerhaft. Verwende Standardwerte");
            }

            // Kommandozeilenargumente, Umgebungsvariablenm, File-Properties oder Default-Werte 
            String sinPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_SIN", properties, "sensoren/sinus");
            String cosPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_COS", properties, "sensoren/cosinus");
            String tanPubTopic = getTopicFromArgsOrEnv(args, "MQTT_PUB_TOPIC_TAN", properties, "sensoren/tangens");
            String subTopic = getTopicFromArgsOrEnv(args, "MQTT_SUB_TOPIC", properties, "feedback/java");

            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            client.connect(options);

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

        /**
         * args ist ein Array von Strings, das alle Kommandozeilenargumente enthält, die an das Programm übergeben wurden
         * wenn args.length > 0 ist, bedeutet das, dass Argumente übergeben wurden
         * dann es überprüft, ob das Argument --MQTT_PUB_TOPIC_SIN etc ist
         * wenn ja, wird der Wert des nächsten Index zurückgegeben
         */ 

        // Kommandozeilenargumente überprüfen
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equalsIgnoreCase("--" + propertyKey)) {
                    if (i + 1 < args.length) {
                        return args[i + 1];
                    }
                }
            }
        }

        // Umgebungsvariablen überprüfen
        String envValue = System.getenv(propertyKey);
        if (envValue != null && !envValue.isEmpty()) {
            return envValue;
        }

        // Fallback auf die Konfigurationsdatei
        return properties.getProperty(propertyKey, defaultValue);
    }

    // Methode, die die Sensordaten veröffentlicht/erstellen
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Output: 
``` config
Gesendet an sensoren/sinus: -0.3507832276896215
Gesendet an sensoren/tangens: 0.3745856401585967
Gesendet an sensoren/cosinus: -0.9364566872907957
Gesendet an sensoren/cosinus: -0.8967584163341462
Gesendet an sensoren/sinus: -0.44252044329485407
Gesendet an sensoren/tangens: 0.49346672998490604
Gesendet an sensoren/tangens: 0.6247330752245663
Gesendet an sensoren/sinus: -0.5298361409084948
Gesendet an sensoren/cosinus: -0.8481000317104072
Gesendet an sensoren/tangens: 0.7735560905031293
Gesendet an sensoren/sinus: -0.6118578909427207
Gesendet an sensoren/cosinus: -0.7909677119144154
Gesendet an sensoren/sinus: -0.6877661591839753
Gesendet an sensoren/tangens: 0.9474246499358968
Gesendet an sensoren/cosinus: -0.7259323042001387
Gesendet an sensoren/cosinus: -0.6536436208636106
Gesendet an sensoren/sinus: -0.7568024953079294
Gesendet an sensoren/tangens: 1.1578212823495817
Gesendet an sensoren/cosinus: -0.5748239465332677
Gesendet an sensoren/sinus: -0.8182771110644114
Gesendet an sensoren/tangens: 1.4235264831943701
Gesendet an sensoren/cosinus: -0.49026082134069865
Gesendet an sensoren/sinus: -0.8715757724135886
Gesendet an sensoren/tangens: 1.7777797745088455
```
