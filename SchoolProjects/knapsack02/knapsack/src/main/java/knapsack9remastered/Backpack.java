package knapsack9remastered;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    protected String name;
    protected int maxWeight;
    protected List<Item> items;
    protected PackStrategy strategy;

    public Backpack(int maxWeight, String name) {
        this.maxWeight = maxWeight;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPackStrategy(PackStrategy strategy) {
        this.strategy = strategy;
    }

    public void packItems() {
        if (strategy != null) {
            strategy.packItems(items, maxWeight);
        } else {
            System.out.println("Keine Packungsstrategie gesetzt!");
        }
    }

    public void empty() {
        items.clear();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
		int totalWeight = 0;
	    for (int i = 0; i < items.size(); i++) {
	    	
	        totalWeight += items.get(i).getWeight();
	    }
	    return totalWeight;
	}

    public String listCurrentItems() {
	    String allItems = "";
	    for (int i = 0; i < items.size(); i++) {
	        allItems += items.get(i).getName() + " => " + items.get(i).getWeight() + "\n";
	    }
	    return allItems;
	}
}
