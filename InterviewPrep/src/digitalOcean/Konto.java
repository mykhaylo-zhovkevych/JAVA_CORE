package digitalOcean;

public class Konto {

	// private Attributen, die nicht von aussen nicht direkt zugänglich sind
	private String kontoinhaber;
	private double kontostand;
	
	
	public Konto(String kontoinhaber, double startkapital) {
		this.kontoinhaber = kontoinhaber;
		kontostand = startkapital;
	}
	
	// Öffentliche Methode zum Abrufen des kontoinhaber
	public String getKontoinhaber() {
		return kontoinhaber;
	}
	
	
	// Öffentliche Methode zum Abrufen des kontostand
	public double getKontostand() {
		return kontostand;
	}
	
	public void einzahlen(double betrag) {
		if (betrag > 0) {
			kontostand += betrag;
		}
		else {
			System.out.println("Der Einzahlungsbetrag muss positiv sein");
		}
	}
	
	public void abheben(double betrag) {
		if(betrag > 0 && betrag <= kontostand) {
			kontostand -= betrag;
		}
		else {
			System.out.println("Ungültiger Abhebungsbetrag");
		}
	}
	
		
		
	
	public static void main(String[] main) {
		
		Konto meinKonto = new Konto("Max Mastermann",1000);		
		
		System.out.println("Kontoinhaber: " + meinKonto.getKontoinhaber());
        System.out.println("Aktueller Kontostand: " + meinKonto.getKontostand() + " Euro");
		
        
        meinKonto.einzahlen(500);
        System.out.println("Kontostand nach Einzahlung: " + meinKonto.getKontostand() + " Euro");
        
        // Versuchen, einen ungültigen Betrag abzuheben
        meinKonto.abheben(2000);
        System.out.println("Kontostand nach versuchter Abhebung: " + meinKonto.getKontostand() + " Euro");
        
	}
}
