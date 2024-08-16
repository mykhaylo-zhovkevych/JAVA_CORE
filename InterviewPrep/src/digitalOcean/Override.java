package digitalOcean;


// Klass: Rechner
public class Override {
	public int addiere(int a, int b) {
		return a + b;
	}
	
	public int addiere(int a, int b, int c) {
		return a + b + c;
	}
	
	public static void main(String[] args) {
		Override rechner = new Override();
		
		System.out.println(rechner.addiere(2, 3));
		System.out.println(rechner.addiere(2, 3, 5));
	}
} 
