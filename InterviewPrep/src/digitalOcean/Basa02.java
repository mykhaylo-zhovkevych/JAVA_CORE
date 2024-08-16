package digitalOcean;



class Fahrzeug {
	
	
	/*
	 * Diese Variable wird verwendet, um die Anzahl der erstellten Fahrzeug-Objekte zu zählen. 
	 * Sie gehört zur Klasse Fahrzeug und wird jedes Mal erhöht, wenn ein neues Fahrzeug-Objekt erstellt wird.
	 * 
	 * */
	
	// statische variable (Klassenvariable)
	private static int anzahlFahrzeuge = 0;
	
	
	// Diese Variablen gehören zu jeder Instanz der Fahrzeug-Klasse. Jede Fahrzeug- oder Auto-Instanz hat ihre eigenen Werte für marke und baujahr.
	
	// instanzvariable 
	private String marke;
	private int baujahr;
	
	
	public Fahrzeug (String marke, int baujahr) {
		this.marke = marke;
		this.baujahr = baujahr;
		anzahlFahrzeuge++;  // Zählt jedes erstellte Fahrzeug
		
	}
	
	// Statische Methode
	public static int getAnzahlFahrzeuge() {
		
		return anzahlFahrzeuge;
		
	}
	
	// Instanzmethode
	public void anzeigenDetails() {
		
		System.out.println("Marke: "+ marke);
		System.out.println("baujahr"+baujahr);
		
		
	}
	
	
}

	
	class Car extends Fahrzeug {
		// zusätzliche instanzvariable für die Cars
		private int sitzplaetze;
		
		// Konstruktor
		public Car(String marke, int baujahr, int sitzplaetze) {
			super(marke, baujahr);
			this.sitzplaetze = sitzplaetze;
		}
		
		// Überschreiben methode ausder basiskklasse
		
		public void anzeigenDetails() {
			super.anzeigenDetails();
			System.out.println("Sitzplätze: "+sitzplaetze);
		}
		
		// Instanzmethode
		public void fahren() {
			System.out.println("Das Car fährt.");
		}
		
	}




//Hauptklasse mit main-Methode
public class Basa02 {

	 
	public static Fahrzeug erstelleFahrzeug() {
		// Lokale Variable
        String marke = "Unbekannt";
        return new Fahrzeug(marke, 2023);
	}
	
	
	
	public static void main(String[] args) {
        // Erstellen einer Instanz von Fahrzeug
        Fahrzeug fahrzeug1 = new Fahrzeug("Toyota", 2022);

        // Erstellen einer Instanz von Car
        Car Car1 = new Car("BMW", 2021, 5);

        // Aufruf einer statischen Methode
        System.out.println("Anzahl der Fahrzeuge: " + Fahrzeug.getAnzahlFahrzeuge());

        // Aufruf von Instanzmethoden
        fahrzeug1.anzeigenDetails();
        Car1.anzeigenDetails();
        Car1.fahren();

        // Lokale Variable in der main-Methode
        Fahrzeug fahrzeug2 = erstelleFahrzeug();
        fahrzeug2.anzeigenDetails();

        // Aufruf einer statischen Methode nach Erstellen weiterer Instanzen
        System.out.println("Anzahl der Fahrzeuge: " + Fahrzeug.getAnzahlFahrzeuge());
    }
	
	
	
	
}
