package knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BackpackTest {

    private Backpack backpack;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;

    @BeforeEach
    public void setUp() {
    	// Testfall 01
        backpack = new Backpack(2000, "Mein Rucksack");
        // Testfall 02
//      backpack = new Backpack(2100, "Mein Rucksack");
        
        item1 = new Item(500, "Laptop");
        item2 = new Item(200, "Buch01");
        item3 = new Item(3000, "Flasche Wasser");
        item4 = new Item(1900, "Buch02");
        item5 = new Item(100, "Flasche Coca Cola");
    }

    
    @Test
    public void testOptimalWeight() {
        
        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);
        backpack.addItem(item4);
        backpack.addItem(item5);

       
        backpack.packItems();

        // Testfall 01
        int expectedOptimalWeight = 2000;
        // Testfall 02
//      int expectedOptimalWeight = 2100;
        int actualWeight = backpack.getCurrentWeight();

        // Überprüfen, ob das tatsächliche Gewicht dem optimalen Gewicht entspricht
        assertEquals(expectedOptimalWeight, actualWeight);

    }
}

