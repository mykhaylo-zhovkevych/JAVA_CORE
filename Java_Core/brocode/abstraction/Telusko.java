package brocode.abstraction;

public class Telusko {
public static void main(String[] args) {

    
car obj = new WagonR();
obj.drive();
obj.playMusic();
obj.fly();


}
}
// i can have the abstrac metho only in the class
abstract class car {

public void playMusic() {
    System.out.println("play music");
}


public abstract void drive();
public abstract void fly();


public void go() {
}
}

class WagonR extends car {
public void drive() {
    System.out.println("Driving");
}
@Override
public void fly() {
    System.out.println("car is flying");
}
}
// abstract is in this example is like the method drive of a car has no implimantation because i dont know how the car works inside that is why
// i'll use the abstract method to postpose the process of bulding that class because i dont haev that expertise in it but somebody might have.
// https://www.youtube.com/watch?v=VJh2u7NLLDg