package knapsack9remastered;

import java.util.List;

public interface PackStrategy {
	
    void packItems(List<Item> items, int maxWeight);
}
