package telusko.polymorphism;

class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}

public class compileTimePolymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Calling the method that adds two integers
        System.out.println(calc.add(5, 3)); // Output: 8
        
        // Calling the overloaded method that adds two doubles
        System.out.println(calc.add(5.5, 3.3)); // Output: 8.8
    }
}