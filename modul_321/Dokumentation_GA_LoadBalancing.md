# Die Dokumentation über MQ Block4: Load Balancing & Monitoring.

_Erstellt von Mykhaylo Zhovkevych_

_Abgaben Datum: 27.03.25_

_Einleitung/ Thema_
Diese Dokumentation beschreibt die Theorethische Fragen beantwortung und die Praktischen Anteil, wo die Einsetzung von Prometheus und Grafana



## Load Balancing Strategien:

#### Least Response Time 
1. Der Load Balancer sendet Angragen an den Server mit der niedrigsten Antwortzeit(Response Time).
2. Die Antwortzeit wird durch regelmässige Health-Checks gemessen.
3. Ideal für Systeme, bei denen die Server unterschiedliche Verarbeitungsgeschwindigkeit haben.

#### Least Connection 
1. Der Load Balancer leitet den Datenverkehr an den Server mit den wenigsten aktiven Verbindungen weiter.
2. Besonders nützlich für lange laufende Anfragen oder Echtzeitanwendungen, da stark ausgelastete Server vermieden werden.

#### Weighted Round Robin
1. Eine Erweiterung von Round Robin, bei der leistungsfähigere Server mehr Anfragen erhalten.
2. Jeder Server hat eine Gewicht, das seine Kapazität widerspiegelt.

#### IP Hashing 
1. Ein Algorithmus erzeugt aus der IP-Adresse des Clients einen Hash-Wert.
2. Der Hash bestimmt, zu welchem Server die Anfrage geht.
3. Gut für Session-Persistenz ohne Sticky Sessions.

## Unterschied zwischen Stateless und Session Tracked Load Balancing

Stateless Load Balancing:
1. Jeder Anfrage wird unabhängig behandelt, ohne dass frühere Anfragen berücksichtigt werden.
2. Der Load Balancer verteilt die Last frei über alle verfügbare Server.
Vorteile: Skalierbar, einfach zu implementieren.
Nachteile: benutzer können bei jedem neunen Request auf einem anderen Server laden.

Session Tracked(Statefull) Load Balancing 
1. Der Load Balancer merkt sich, welcher Benutzer welchem Server zugeordnet wurde(Session Persistence)

    Methoden:
    1. Sticky Sessions (Session Affinity): Clients werden während ihrer Sitzung immer zum selben Server geleitet.
    2. IP Hashing: Requests von einer bestimmten IP-Adresse landen immer beim selben Server.

Vorteil: Wichtige für Anwendungen mit Sitzungsdaten (z. B. Online-Shops, Banking). 
Nachteil: Weniger flexibel und kann zu Lastungleichgewicht führen.

