package knapsack;

public class Main {
    public static void main(String[] args) {
        
        Item item1 = new Item(500, "Laptop");
        Item item2 = new Item(200, "Buch01");
        Item item3 = new Item(3000, "Flasche Wasser");
        Item item4 = new Item(200, "Buch02");
        
        Backpack backpack = new Backpack(1000, "Mein Rucksack");

        
        System.out.println("Füge " + item1.getName() + " hinzu: " + backpack.addItem(item1)); 
        System.out.println("Füge " + item2.getName() + " hinzu: " + backpack.addItem(item2)); 
        System.out.println("Füge " + item3.getName() + " hinzu: " + backpack.addItem(item3)); 
        System.out.println("Füge " + item4.getName() + " hinzu: " + backpack.addItem(item4));  

        System.out.println("Vergleiche "+ item2.getName() + " und " + item4.getName() + " = " + Item.equals(item2, item4)); 
        System.out.println("Vergleiche "+ item1.getName() + " und " + item3.getName() + " = " + Item.equals(item1, item3)); 
        
        System.out.println("Aktuelles Gewicht des Rucksacks: " + backpack.getCurrentWeight() + " Gramm");

        

    }
}

