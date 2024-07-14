package knapsack08;


import java.util.ArrayList;
import java.util.List;

public class BubbleSortPackingStrategy extends PackingStrategy {
    
	@Override
    public void packItems(List<Item> items, int maxWeight) {
        boolean swapped;
        for (int i = 0; i < items.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < items.size() - i - 1; j++) {
                if (items.get(j).getWeight() < items.get(j + 1).getWeight()) {
                    Item temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        List<Item> packedItems = new ArrayList<>();
        int currentWeight = 0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (currentWeight + item.getWeight() <= maxWeight) {
                packedItems.add(item);
                currentWeight += item.getWeight();
            }
        }
        
        // Anstatt damit zu referenzieren mit this, für der gurgabe collector kann ich einfach die alte list leeren und die neue hinzufügen 
        items.clear();
        items.addAll(packedItems);
    }
}