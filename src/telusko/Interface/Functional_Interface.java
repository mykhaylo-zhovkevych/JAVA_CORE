package telusko.Interface;

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

