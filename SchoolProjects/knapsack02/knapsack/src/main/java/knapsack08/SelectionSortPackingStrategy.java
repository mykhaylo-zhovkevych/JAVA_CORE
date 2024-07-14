package knapsack08;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortPackingStrategy extends PackingStrategy {
    @Override
    public void packItems(List<Item> items, int maxWeight) {
        
        for (int i = 0; i < items.size() - 1; i++) {
            // Initialisierung placeholder für erste grösser Zahl
            int maxIdx = i;
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j).getWeight() > items.get(maxIdx).getWeight()) {
                	maxIdx = j;
                }
            }
            
            // temp speichert das Element bei maxIdx
            Item temp = items.get(maxIdx);
            // Das Element bei maxIdx wird durch das Element bei i ersetzt
            items.set(maxIdx, items.get(i));
            // Das Element bei i wird durch temp ersetzt
            items.set(i, temp);
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
