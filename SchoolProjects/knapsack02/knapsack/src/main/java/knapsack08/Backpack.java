package knapsack08;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Backpack Klasse dient zum Hinzufügen, Löschen und Abrufen neuer Gegenstände.
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 * 
 */
public class Backpack {
	
    protected String name;
    protected int maxWeight;
    protected List<Item> items;
    protected int currentWeight;

    /**
	 * Konstruktor, um ein neues Item zu erstellen.
	 * 
	 * @param weight Das Gewicht des Gegenstands.
	 * @param name Der Name des Gegenstands.
	 */
    Backpack(int maxWeight, String name) {
        this.maxWeight = maxWeight;
        this.name = name;
        this.items = new ArrayList<>();
    }

	/**
     * Fügt einen Gegenstand zur Liste der möglichen Gegenstände hinzu.
     *
     * @param item Der hinzuzufügende Gegenstand.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Sortiert die Gegenstände und packt den Rucksack so, dass das Maximalgewicht nicht überschritten wird.
     */
    public void packItems(Packable method) {
    	method.packItems(items, maxWeight);
        currentWeight = getCurrentWeight();
    }

    /**
	 * Leert den Rucksack, indem alle Gegenstände entfernt werden.
	 */
    public void empty() {
        items.clear();
    }

    /**
	 * Gibt das maximale Gewicht des Rucksacks zurück.
	 * 
	 * @return Das maximale Gewicht des Rucksacks.
	 */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
	 * Berechnet und gibt das aktuelle Gewicht der im Rucksack enthaltenen Gegenstände zurück.
	 * 
	 * @return Das aktuelle Gewicht der im Rucksack enthaltenen Gegenstände.
	 */
    public int getCurrentWeight() {
		int totalWeight = 0;
	    for (int i = 0; i < items.size(); i++) {
	    	
	        totalWeight += items.get(i).getWeight();
	    }
	    return totalWeight;
	}

    /**
     * Listet die aktuellen Gegenstände im Rucksack auf.
     * 
     * @return Eine String mit allen Gegenständen und deren Gewichten.
     */
    public String listCurrentItems() {
	    String allItems = "";
	    for (int i = 0; i < items.size(); i++) {
	        allItems += items.get(i).getName() + " => " + items.get(i).getWeight() + "\n";
	    }
	    return allItems;
	}
}