//package knapsack;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class BackpackTest {
//
//	// nur innerhalb der Testklasse verwendet werden
//    private Backpack backpack;
//    private Item item1;
//    private Item item2;
//    private Item item3;
//    private Item item4;
//    private Item item5;
//
//    @Before
//    public void setUp() {
//        backpack = new Backpack(1000, "Test Rucksack");
//        item1 = new Item(500, "Laptop");
//        item2 = new Item(200, "Buch01");
//        item3 = new Item(3000, "Flasche Wasser");
//        item4 = new Item(200, "Buch02");
//        item5 = new Item(100, "Flasche Coca Cola");
//    }
//
//    @Test
//    public void testMaxWeightNotExceeded() {
//        assertTrue(backpack.addItem(item1));
//        assertTrue(backpack.addItem(item2));
//        assertFalse(backpack.addItem(item3));
//        assertTrue(backpack.addItem(item4));
//        assertTrue(backpack.addItem(item5));
//    }
//}



