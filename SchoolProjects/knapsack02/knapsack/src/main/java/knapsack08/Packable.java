package knapsack08;

import java.util.List;

/**
 * Interface Packable, die die Methode packItems zur Verfügung stellt.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 * 
 * */
public interface Packable {
	
    void packItems(List<Item> items, int maxWeight);
}