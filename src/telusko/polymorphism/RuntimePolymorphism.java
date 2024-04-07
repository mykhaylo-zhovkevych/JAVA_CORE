package telusko.polymorphism;


class Animal {
    void speak() {
        System.out.println("The animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("The dog barks");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("The cat meows");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        
        myAnimal.speak(); // Output: The animal speaks
        myDog.speak();    // Output: The dog barks
        myCat.speak();    // Output: The cat meows
    }
}
