package knapsack08;


import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
    	
        Item item1 = new Item(500, "Laptop");
        Item item2 = new Item(200, "Buch01");
        Item item3 = new Item(3000, "Flasche Wasser");
        Item item4 = new Item(1900, "Buch02");

        int maxWeight = 5000;
        Backpack backpack = new Backpack(maxWeight, "Mein Rucksack");
        
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

       
        // Erste Strategie: SelectionSort
        Packable SelectionSortStrategy = new SelectionSortPackingStrategy();
        backpack.empty();
        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);
        backpack.addItem(item4);
        backpack.packItems(SelectionSortStrategy);

        System.out.println("Ergebnis der SelectionSort-Strategie:");
        System.out.println("Aktuelles Gewicht des Rucksacks: " + backpack.getCurrentWeight() + " Gramm");
        System.out.println("Gegenstände in der Rücksack:");
        System.out.println(backpack.listCurrentItems());

        // Zweite Strategie: BubbleSort
        Packable bubbleSortStrategy = new BubbleSortPackingStrategy();
        backpack.empty();
        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);
        backpack.addItem(item4);
        backpack.packItems(bubbleSortStrategy);

        System.out.println("Ergebnis der BubbleSort-Strategie:");
        System.out.println("Aktuelles Gewicht des Rucksacks: " + backpack.getCurrentWeight() + " Gramm");
        System.out.println("Gegenstände in der Rücksack:");
        System.out.println(backpack.listCurrentItems());
    }
}