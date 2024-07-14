package knapsack9remastered;

public class Item {
    protected int weight;
    protected String name;

    public Item(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
