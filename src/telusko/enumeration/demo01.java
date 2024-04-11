package telusko.enumeration;

enum Laptop {
    Macbook(2000), XPS(2200), Surface, ThinkPad(2999);
    
    private Integer price; // Use Integer to allow null values

    // Constructor for Laptops with a price
    private Laptop(int price) {
        this.price = price;
    }
    
    // Default constructor for Laptops without a specified price
    private Laptop() {
        this.price = null; // null indicates "not for sale"
    }

    public String getPrice() {
        if (price == null) {
            return "not for sale";
        } else {
            return String.valueOf(price);
        }
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}

public class demo01 {
    public static void main(String[] args) {
        for (Laptop lap : Laptop.values()) {
            System.out.println(lap + ":" + lap.getPrice());
        }
    }
}
