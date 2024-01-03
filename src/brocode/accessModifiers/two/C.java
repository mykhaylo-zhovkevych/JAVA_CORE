package brocode.accessModifiers.two;
import brocode.accessModifiers.one;

public class C {

    // anything that uses the default modifier is only visible in the class or the same package, if i want to call the method from another pacakge it will be no possible 
String defaultMessage = "this is the default";
// public is visible to any class and pacakge folder
public String publicMessage = "this is public";

protected String protectedMessage = "this is protected";
// The protected modifier provides a balance between encapsulation and visibility.
// Within the Same Package: Members with the protected access modifier can be accessed by any class within the same package.
// Outside the Package, by Subclasses Only: Members with the protected access modifier can also be accessed by subclasses, even if they are in a different package.
private String privateMessage = "this is private";
// privated that is somethign that is only visible in the class that is contains 
}



/*
// Superclass or Parent class
class Animal {
    void eat() {
        System.out.println("The animal eats food.");
    }
}

// Subclass or Child class
class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }

    // Overriding the eat method from the superclass
    @Override
    void eat() {
        System.out.println("The dog eats bones.");
    }
}
*/
/*
 In this example, Animal is the superclass, and Dog is the subclass. 
 The Dog class inherits the eat method from the Animal class and adds a new method called bark. 
 The eat method is also overridden in the Dog class to provide a specific implementation for dogs.
*/