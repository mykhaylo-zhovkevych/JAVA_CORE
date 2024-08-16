package digitalOcean;

// 2. How do you swap two numbers without using a third variable in Java?
// 2.1 How do you swap two numbers with using a third variable in Java?
public class Problem02 {

	public static void main(String[] args) {
		// 2.1 How do you swap two numbers with using a third variable in Java?
		
		int a = 10;
		int b = 20;
		
		System.out.println("Before a is " + a + " and b is " + b);
		
		// Initialize and stores a 
		int temp = a;
		// a override the b takes it's place 
		a = b;
		//until now the a has to places and b none so...
		b = temp;
		
		System.out.println("After a is " + a + " and b is " + b + "\n");
		
		
		// 2. How do you swap two numbers without using a third variable in Java?
		
		int c = 100;
		int f = 50;
		
		System.out.println("Before c is " + c + " and f is " + f);
		
		c = c + f; // 150
		// 100 = 150 - 50
		f = c - f;
		// 50 = 150 - 100
		c = c - f;
		
		System.out.println("After c is " + c + " and f is " + f);
	}
	
}
