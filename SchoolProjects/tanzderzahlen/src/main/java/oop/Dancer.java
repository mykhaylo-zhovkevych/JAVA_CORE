package oop;

/**
 * 
 * Klasse mit Dancer die implements Comparable Interface
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class Dancer implements Comparable<Dancer>{

	/**
	 *  Attribute
	 */
    String name;
    int number;

    /**
     * Konstruktor
     * In UML es besteht ein Widerspruch, denn es gibt: number int und bei Konstruktor String
     * 
     *  @param name
     *  @param number
     *  
     * */
    public Dancer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
	 *  Methode getName für name retournieren
	 *  @return name
	 */
    public String getName() {
        return name;
    }
    /**
	 *  Methode getNumber für number retournieren
	 *  @return number
	 */
    public int getNumber() {
        return number;
    }

    /**
	 *  Überschreibmethode toString die Output verwaltet
	 *  @return name, number
	 */
    @Override
    public String toString() {
        return "Dancer => name: " + name + " ==> number= " + number;
    }

    /**
     *  compareTo nimmt ein Dancer-Objekt als Argument (other)
     *  und leitet dann den Vergleich der number-Eigenschaften der beiden Objekte weiter
     *  Die Methode Integer.compare wird verwendet, um zu überprüfen, ob
     *  - this.number kleiner als other.number ist (gibt -1 zurück)
     *  - this.number gleich other.number ist (gibt 0 zurück)
     *  - this.number grösser als other.number ist (gibt 1 zurück)
     *  Diese Methode ermöglicht die Sortierung von Dancer-Objekten basierend auf ihrer number-Eigenschaft
     *  
     *  @param Dancer
     *  @return Integer
     */
    @Override
    public int compareTo(Dancer other) {
        return Integer.compare(this.number, other.number);
        
        // Dancer0(0) vs. Dancer3(3) -> Keine Änderung.
        // Dancer3(3) vs. Dancer1(1) -> Austausch: Dancer1(1) kommt vor Dancer3(3).
        // etc
    }
}
