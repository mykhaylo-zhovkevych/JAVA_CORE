package digitalOcean;

//Oberklasse (Basisklasse)
class Tier01 {
 private String name;

 // Konstruktor
 public Tier01(String name) {
     this.name = name;
 }

 // Methode zum Abrufen des Namens
 public String getName() {
     return name;
 }

 // Methode zum Bewegen
 public void bewegen() {
     System.out.println(name + " bewegt sich.");
 }

 // Methode zum Geräusch machen (kann von Unterklassen überschrieben werden)
 public void machenGeräusch() {
     System.out.println(name + " macht ein Geräusch.");
 }
}











//Unterklasse (Subklasse) Hund01
class Hund01 extends Tier01 {

 // Konstruktor
 public Hund01(String name) {
     super(name);  // Aufruf des Konstruktors der Oberklasse
 }

 // Überschreiben der Methode machenGeräusch

 public void machenGeräusch() {
     System.out.println(getName() + " bellt: Wuff!");
 }
}

//Unterklasse (Subklasse) Katze01
class Katze01 extends Tier01 {

 // Konstruktor
 public Katze01(String name) {
     super(name);  // Aufruf des Konstruktors der Oberklasse
 }

 // Überschreiben der Methode machenGeräusch

 public void machenGeräusch() {
     System.out.println(getName() + " miaut: Miau!");
 }
}

//Hauptprogramm (Main-Methode)
public class VererbungBeispiel {
 public static void main(String[] args) {
     // Erstellen von Objekten der Unterklassen
     Hund01 meinHund01 = new Hund01("Bello");
     Katze01 meineKatze01 = new Katze01("Mimi");

     // Aufruf der geerbten und überschriebenen Methoden
     meinHund01.bewegen();
     meinHund01.machenGeräusch();

     meineKatze01.bewegen();
     meineKatze01.machenGeräusch();
 }
}
