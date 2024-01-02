package brocode.overloadingMethods;

public class main {
    public static void main(String[] args) {
        //overloaded methods = methods that share the same name but have different paramaters.
        //method name + parameters = method signature.
        int x = add(1,2);

        System.out.println(x);
    }

    static int add(int a, int b) {
        System.out.println("this is method one");
        return a + b;

    }

    static int add(int a, int b, int z) {
        System.out.println("this is method two");
        return a + b + z;

    }

    static int add(int a, int b, int z, int f) {
        System.out.println("this is method three");
        return a + b + z + f;

    }
} // overloaded methods can accept different datatype like int double etc 

