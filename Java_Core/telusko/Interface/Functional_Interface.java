package telusko.Interface;

/*
a functional interface is defined as an interface with only one abstract method 
(also known as a Single Abstract Method (SAM) interface). 
This is the fundamental characteristic that enables the interface to be used in lambda expressions, method references, and functional-style programming.
*/
// by doing this i make sure that i have only one method here 
@FunctionalInterface 
interface A {
    void show(int i);

}

public class Functional_Interface {
    public static void main(String[] args) {
//        A obj = new A() {
//            public void show() {
//                System.out.println("in show");
//            }
//        };
// this lambda will not create class behind the scenes but he class Functional_Interface will be larger in the saze
        A obj = (int i) -> System.out.print("this is show and in lambda expression " + i);
        obj.show(5);    
        
        // this part of the code shows how the code works in uncompressed form 
//        A obj = new A() {
//            public void show(int i) {
//                System.out.println("in show"+i);
//            }
//        };
//        obj.show(5);

// behind the scene the compiler will do it for me like typing all this but because i declar A and like use @FunctionalInterface complier know waht to do by itself 
        
    }
}

