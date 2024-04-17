package brocode.methodOverriding;

/*Method overriding = declaring a method in sub class, 
 * which is already present in parent class.
 * done so that a child class can give its own implementation
 */

public class main {
public static void main(String[] args) {
    
    animal Animal = new animal();
    dog Dog = new dog();

    Dog.speak();
    Animal.speak();
    }
}
