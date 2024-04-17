package telusko.polymorphism;

class Computer {


    
}

class Laptop  extends Computer{


}

class A {

    public void show() {

        System.out.println(" in A show");

    }

}

class B extends A {

    public void show() {

        System.out.println(" in B show");

    }

}

class C extends A {

    public void show() {

        System.out.println(" in C show");

    }

}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        // type of the variable is here A and implementation is B 
        A obj = new A();
        obj.show();
        // as paramater overrinf it should call in b show, but the reference is of type A 

        // here at the meomory level the link between the heap and stack(101) will be replace with the new memory assignment like (103) and that is why there will be like(output) in B show:
        obj = new B();
        obj.show();

        obj =new C();
        obj.show();
        // so the obj1 can be type as parent and objet can be of child or refrencve of the super class and the object of the subclass
        Computer obj1 = new Laptop ();

/*Dynamic Dispatch." Dynamic dispatch is a key feature of runtime polymorphism in object-oriented 
programming, where the call to an overridden method is resolved at runtime rather than compile-time. 
It enables a program to select a method at runtime rather than compile time, which is crucial for 
implementing polymorphism and inheritance. */

    }

}
