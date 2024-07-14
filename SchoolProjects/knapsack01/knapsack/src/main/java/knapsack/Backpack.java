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
	 * Fügt einen Gegenstand zum Rucksack hinzu, wenn das maximale Gewicht nicht überschritten wird.
	 * 
	 * @param item Der hinzuzufügende Gegenstand.
	 * @return true, wenn der Gegenstand hinzugefügt wurde, sonst false.
	 */
	public boolean addItem(Item item) {
		int currentWeight = getCurrentWeight();
		if(currentWeight + item.getWeight() <= maxWeight) {
			items.add(item);
			return true;
		} else {
			System.out.print("Sie haben das Limit überschritten. Diese Objekte passt nicht: " + item.getName() + "\n");
			return false;
		}

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
	    	// getWeight Methode von Item Klasse
	        totalWeight += items.get(i).getWeight();
	    }
	    return totalWeight;
	}
}
