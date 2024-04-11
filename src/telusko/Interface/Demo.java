package telusko.Interface;

//class - class -> extends
//class - interface -> implements
//interface - interface -> extends

interface A {
// the variables can be also defined 
int age = 44; 
String area = "mumbai";
// they by default: final and static 

public abstract void show();
                void config();

}
/*
Interface is not the class and by defalut every mehtod is public abstract 
the interface can not be instantiated 
the reason why the interface is created because like interface can have a 
 */
// the interface has the variables: static and final by default, because:  
// the Interface is not instantiated, but the class that uses the iterface
interface Y extends A {
    void run();

}

class B implements A, Y {
// in implements i get only the methods but not the variables
    public void show() {
        System.out.println("in show");
    }
    public void config() {
        System.out.println("in config");
    }
    public void run() {
        System.out.println("in run");
    }
}
// one class can implement multiple interfaces, but the class need to have at least the method(can be empty), but defined

public class Demo {
    public static void main(String[] args) {
        A obj; // no problem to create the reference of that 
        obj = new B();
        obj.show();
        obj.config();

        Y obj1 = new B();
        obj1.run();

        //System.out.print(A.age);
        //A.area = "dfdfa"; // will not work 

    }   
}
