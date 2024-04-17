package brocode.abstraction;

public class main {
/**
 * @param args
 */
public static void main(String[] args) {
    
//vehicle Vehical = new vehicle();
car Car = new car();

// abstract = abstract classes cannot be instantiated, but theya can have a subclass
// abstract methods are declared without an implementation
Car.go();
}
}
