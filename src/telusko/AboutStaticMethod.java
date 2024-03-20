package telusko;
class Phone {
    // instance variables
    String brand;
    int price;
    String network;
    static String name; // the name should be the same for all objects


    static {
        name = "Phone"; // Initial value set for the static variable
        System.out.println("in static block");
    }

    public Phone() {
        brand = "no-name";
        price = 200;
        System.out.println("in constructor");
    }

    public void show() {
        // Correctly accessing the static variable through the class name inside the instance method
        System.out.println(brand + ":" + price + ":" + Phone.name);
    }
}



public class AboutStaticMethod {
   public static void main(String[] args) throws ClassNotFoundException {
   
    Class.forName("telusko.Phone");

    Phone phoneInstance = new Phone(); // This will print "in constructor"
    phoneInstance.show(); // This will print the instance details

    }
}

