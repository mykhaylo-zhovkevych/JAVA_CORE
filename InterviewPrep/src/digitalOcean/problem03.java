package digitalOcean;


public class problem03 {
	
	public static void main(String[] args) {
	
		System.out.println(isPrime(19)); // true
		System.out.println(isPrime(49)); // false
		
		
	}
	
	
	public static boolean isPrime(int n) {
		
		if (n == 0 || n == 1) {
			return false;
		}
		if ( n == 2) {
			
			return true;
		}
		
		// this is gone because everthing bigger that the result of the n / 2 can be non-used because it will give wrong answer and + optimization 
		// so like it will start from 2 and end 
		for (int i = 2; i <= n / 2; i++) {
			
			if (n % i == 0) {
				return false;
			}
			
		}
		return true;
	}
	
}
