package telusko.Interface;

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

class B implements A {

    public void show() {
        System.out.println("in show");
    }
    public void config() {
        System.out.println("in config");
    }

}

public class Demo {
    public static void main(String[] args) {
        A obj; // no problem to create the reference of that 
        obj = new B();
        obj.show();
        obj.config();

        System.out.print(A.age);
        A.area = "dfdfa"; // will not work 

    }   
}
