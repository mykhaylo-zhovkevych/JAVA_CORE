package knapsack9remastered;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Item item1 = new Item(500, "Laptop");
        Item item2 = new Item(200, "Buch01");
        Item item3 = new Item(3000, "Flasche Wasser");
        Item item4 = new Item(1900, "Buch02");

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        int maxWeight = 5000;
        Backpack backpack = new Backpack(maxWeight, "Mein Rucksack");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wählen Sie eine Packungsstrategie:");
        System.out.println("1. Bubble Sort Strategy");
        System.out.println("2. Selection Sort Strategy");
        int choice = scanner.nextInt();

        PackStrategy strategy = null;
        switch (choice) {
            case 1:
                strategy = new BubbleSortPackingStrategy();
                break;
            case 2:
                strategy = new SelectionSortPackingStrategy();
                break;
            default:
                System.out.println("Ungültige Wahl, keine Strategie wird gesetzt.");
                break;
        }

        if (strategy != null) {
            backpack.setPackStrategy(strategy);
            backpack.empty();
            backpack.addItem(item1);
            backpack.addItem(item2);
            backpack.addItem(item3);
            backpack.addItem(item4);
            backpack.packItems();

            System.out.println("Ergebnis der gewählten Strategie:");
            System.out.println("Aktuelles Gewicht des Rucksacks: " + backpack.getCurrentWeight() + " Gramm");
            System.out.println("Gegenstände im Rucksack:");
            System.out.println(backpack.listCurrentItems());
        }
    }
}

