package knapsack;

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
    public void packItems() {
        sortItemsByBubbleSort();
        List<Item> packedItems = new ArrayList<>();
        int currentWeight = 0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (currentWeight + item.getWeight() <= maxWeight) {
                packedItems.add(item);
                currentWeight += item.getWeight();
            }
        }
        this.items = packedItems;
        this.currentWeight = currentWeight;
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
	// braucht für die Statement
	public int getCurrentWeight() {
		int totalWeight = 0;
	    for (int i = 0; i < items.size(); i++) {
	    	// getWeight Methode von Item Klasse
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
	
	/**
     * Sortiert die Gegenstände in absteigender Reihenfolge nach Gewicht mithilfe des BubbleSort Algorithmus.
     */
	 public void sortItemsByBubbleSort() {
	        boolean swapped;
	        for (int i = 0; i < items.size() - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < items.size() - i - 1; j++) {
	            	// überprüft ob das aktuelle Element leichter ist als nächste Item
	            	// Buch01 (200), Flasche Wasser (3000) 
	            	// Tausch, da 200 < 3000 
	                if (items.get(j).getWeight() < items.get(j + 1).getWeight()) {
	                	
	                	// Zwischenspeicherung von Buch01 (200)
	                    Item temp = items.get(j);
	                   
	                    // Setzen von Flasche Wasser (3000) an die Position von Buch01 (200)
	                    items.set(j, items.get(j + 1));
	                    // Setzen von Buch01 (200) an die Position von Flasche Wasser (3000)
	                    items.set(j + 1, temp);
	                    swapped = true;
	                }
	            }
	            // Wenn keine zwei Elemente durch innere Schleife ausgetauscht wurden, dann break
	            if (!swapped)
	                break;
	        }
	    }
}
