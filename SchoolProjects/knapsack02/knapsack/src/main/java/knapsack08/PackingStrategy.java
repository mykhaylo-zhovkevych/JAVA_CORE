package knapsack08;

import java.util.List;

/**
 * Die abstrakte Klasse, die nur die Deklaration der Mehtode packItems verantwortlich und diese Methode sind, in zwei konkreten Klassen implementiert.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 * 
 * */
public abstract class PackingStrategy implements Packable {
	
	/**
	 * Methode packItems vorbereitet die Items in der richtigen Reihenfolge.
	 * 
	 * */
    @Override
    public abstract void packItems(List<Item> items, int maxWeight);
}