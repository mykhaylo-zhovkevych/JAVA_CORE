package telusko;

abstract class Car {
    // declaration of the method
    // abstact means i have idea but i dont know how that implement must be 
    // the class how to be abstract
    public abstract void drive();
    
    //public abstract void fly();

    public void palyMusic () {

        System.out.print("play music");
    }
}
// so like the concept the drive is not defeined in the Car class bu will be defined in some aonther class 
class WagonR extends Car {
    public void drive() {

        System.out.print("Driving..");
    }

}

public class Abstract {
    public static void main(String[] args) {
        
        // the object of the abstrat class can not be created 
        // the reference of the abstarct class cen be created 
        Car obj = new WagonR();
        obj.drive();
        obj.palyMusic();



// like I have methods in the Car class and I don't inplement some of them as the class where the implementation of the desired class must also be abstract 
// but after that i wound not be able to crteate the objec of the wanted class     
    }


}
