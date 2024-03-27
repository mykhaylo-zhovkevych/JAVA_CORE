package telusko.Static;

/**
 * InneraboutStatic
 */
 class Phone {
    // instance variables 
    String brand;
    int price;
    String network;
    static String name; // the name should be he same for all objects 

    public void show() {

        System.out.println( brand + ":" + price + ":"  + name);
    }
}

public class aboutStatic {
    public static void main(String[] args) {
        Phone obj1 = new Phone();
        obj1.brand = "Apple";
        obj1.price = 1500;
        obj1.name = "SmartPhone";

        Phone obj2 = new Phone();
        obj2.brand = "Samsung";
        obj2.price = 1000;
        obj2.name = "SmartPhone";

        obj1.name= "phone";

        obj1.show();
        obj2.show();
    }
}
