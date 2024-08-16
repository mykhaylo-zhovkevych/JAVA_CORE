package javaBook;

public class Kapitel10StaticEinführung {
	
	private int nummerDesSchulers;
	
	private static int klssenStark = 0;
	
	public void setzNummer() {
		
		klssenStark++;
		nummerDesSchulers = klssenStark;
		
	}
	
	public void abzahlen() {
		
		System.out.println("Ich bin die Nr: " + nummerDesSchulers);
		
		
		
	}
	
	public static int holeSchuelerAnzahl() {
		
		return klssenStark;
	}
	
	public static void main(String [] args) {
		
		System.out.println("Klassenstärke vor der Einschulung: " + Kapitel10StaticEinführung.holeSchuelerAnzahl());
		
		// Schueler[] schuelerInKlasse = new Schueler[10];
		Kapitel10StaticEinführung[] schuelerInKlasse = new Kapitel10StaticEinführung[10];
		
	for (int lv = 0; lv < schuelerInKlasse.length; lv++) {
		
		schuelerInKlasse[lv] = new Kapitel10StaticEinführung();
		schuelerInKlasse[lv].setzNummer();
		}
	
	
	for (Kapitel10StaticEinführung element : schuelerInKlasse) {
		
		element.abzahlen();
		
		}
	
		System.out.println("Klassenstärke nach der Einschulung: " + schuelerInKlasse [0].holeSchuelerAnzahl());
	}
}
