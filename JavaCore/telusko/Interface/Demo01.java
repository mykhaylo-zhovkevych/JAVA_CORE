package telusko.Interface;

interface Computer{
    void code();
}
/*abstract class Computer {

    public abstract void code();

}*/

class Laptop /*extends*/ implements Computer{

    public void code() {

        System.out.println("coding...");

    }
}

class Developer {

    // here i get the computer reference
    public void devApp(Computer laptop) {
        System.out.println("developing...");
        laptop.code();
    }
}
class Desktop /*extends*/ implements Computer {

    public void code() {

        System.out.println("coding... faster");
    }
}

public class Demo01 {
    public static void main(String[] args) {
        // parent             child class
        Computer laptop = new Laptop();
        Computer desktop = new Desktop();
        // here i pass the computer reference 
        Developer navim = new Developer();
        navim.devApp(desktop);
    }
}

