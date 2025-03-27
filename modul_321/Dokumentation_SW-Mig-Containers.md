## Die Dokumentation über MQ Block3: Migration Strategie und die Containerisierung

Erstellt von Mykhaylo Zhovkevych
Abgaben Datum: 27.03.25


*Einleitung/ Thema*
Diese Dokumentation beschreibt die ausgewählte Migrationsstrategie sowie die schrittweise Umsetzung der Migration von Mosquitto mit Containerisierung. Zusätzlich werden Verbesserungen am Java-Code erläutert.


# Die ausgewählte Strategie
Für diesen Auftrag wurde die Cold Turkey (Big Bang)-Strategie gewählt, da ihre Vorteile die Nachteile überwiegen. Während der Projektumsetzung wurden jedoch einige kritische Fehler aufgedeckt, die während der Systemmigration entstanden sind.
Nach der Behebung dieser Probleme kann das System schnell und einwandfrei eingesetzt werden.

# Die Migrations Erklärung 

Hauptanforderungen

    Erstellung des Images

    Erstellung und Testen von Containern für jeden Sensor

    Containerisierung von Grafana zur Visualisierung der Daten

    Erstellung eines Testplans und einer Protokollierung

Zunächst habe ich die Container erstellt, damit später das finale Image erzeugt und veröffentlicht werden kann.

Mithilfe der docker-compose.yml-Datei habe ich drei Container erstellt, die Umgebungsvariablen nutzen. Zudem habe ich dort auch den MQTT-Broker und Grafana definiert.

``` yaml
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
      - "3000:3000"   # Grafana-Webinterface auf Port 3000
    networks:
      - mqtt_net
    environment:
      - GF_SECURITY_ADMIN_PASSWORD=admin  # Standard-Admin-Passwort für Grafana
    volumes:
      - grafana_data:/var/lib/grafana  # Speichert die Grafana-Daten persistent

networks:
  mqtt_net:
    driver: bridge

volumes:
  grafana_data:  # Erstelle ein Volume für Grafana-Daten
```

Die kompilierte Java-Anwendung sowie die Konfigurationsdatei werden in den Container kopiert, damit sie containerisiert werden können.

``` Dockerfile 
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




Output:
``` yml
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

# Testplan 

// Hier folgt die abschließende Bewertung der Migration.


# Schlussfolderung 




