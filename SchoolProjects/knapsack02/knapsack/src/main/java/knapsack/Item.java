package knapsack;

/**
 * Klasse, die das Gegenstand bereitstellt und die Gegenstände vergleicht.
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 * 
 */
public class Item {
	
	/**
	 * Der Name und das Gewicht des Gegenstands.
	 */
	// Instanzvariablen 
	protected String name;
	protected int weight;
	
	/**
	 * Konstruktor, um ein neues Item zu erstellen.
	 * 
	 * @param weight Das Gewicht des Gegenstands.
	 * @param name Der Name des Gegenstands.
	 */
	Item(int weight, String name) {
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * Gibt das Gewicht des Gegenstands zurück.
	 * 
	 * @return Das Gewicht des Gegenstands.
	 */
	public int getWeight() {
		
		return weight;
	}
	
	/**
	 * Gibt den Namen des Gegenstands zurück.
	 * 
	 * @return Der Name des Gegenstands.
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Vergleicht zwei Items basierend auf ihrem Gewicht.
	 * 
	 * @param item1 Das erste Item.
	 * @param item2 Das zweite Item.
	 * @return true, wenn beide Items das gleiche Gewicht haben, sonst false.
	 */
	// statische Methode mit Instanzvariablen als Parameter 
	public static boolean equals(Item item1, Item item2) {
        if (item1 == null || item2 == null) return false; 
        return item1.weight == item2.weight;
    }
	
}
