package polymorphismus;

class MathOperations {
	public int add(int a, int b) {
		return a + b;
	}
	
	
	public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
	
}

public class StatischerPolymorphismus {

	public static void main(String [] arsg) {
		
		MathOperations mo = new MathOperations();
		
		 System.out.println(mo.add(2, 3));        // Ausgabe: 5
	     System.out.println(mo.add(2.5, 3.5));    // Ausgabe: 6.0
	     System.out.println(mo.add(1, 2, 3));     // Ausgabe: 6
		
	}
	
}
