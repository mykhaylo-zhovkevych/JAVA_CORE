package brocode.objactPassing;

public class main {

public static void main(String[] args) {
    
    garage Garage = new garage();

    car Car = new car("BMW");
    car Car2 = new car("Tesla");

    Garage.park(Car);
    Garage.park(Car2);


    }

}

/*
 * In summary, the main class creates instances of the garage and car classes, and it passes the car 
 * objects to the park method of the garage class. The garage class then processes these objects and prints
 *  messages based on their attributes. This demonstrates how objects can be passed between classes in Java.
 * FURTHER BETTER EXPLINATION IS IN THE ONENOTE 
 */

