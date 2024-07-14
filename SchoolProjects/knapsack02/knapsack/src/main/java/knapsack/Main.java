package knapsack;

public class Main {
    public static void main(String[] args) {
        
        Item item1 = new Item(500, "Laptop");
        Item item2 = new Item(200, "Buch01");
        Item item3 = new Item(3000, "Flasche Wasser");
        Item item4 = new Item(1900, "Buch02");
        
        Backpack backpack = new Backpack(5000, "Mein Rucksack");

        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);
        backpack.addItem(item4); 

        backpack.packItems(); 
        
        System.out.println("Aktuelles Gewicht des Rucksacks: " + backpack.getCurrentWeight() + " Gramm");
        System.out.println("Gegenstände in der Rücksack:");
        System.out.println(backpack.listCurrentItems());
         
        
        System.out.println("Vergleiche "+ item2.getName() + " und " + item4.getName() + " = " + Item.equals(item2, item4)); 
        System.out.println("Vergleiche "+ item1.getName() + " und " + item3.getName() + " = " + Item.equals(item1, item3)); 
        
      

    }
}

