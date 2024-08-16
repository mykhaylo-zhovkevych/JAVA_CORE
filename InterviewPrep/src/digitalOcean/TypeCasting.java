package digitalOcean;

public class TypeCasting {
	
	public static void main(String [] args) {
		
		// Implizites Casting (automatisch): kleinerer Typ zu größerem Typ
		int myInt = 9;
		double myDouble = myInt; // int zu double
		
		System.out.println("Int zu Double: " + myDouble); // 9.0 
		
		// Explizites Casting (manuell)
		double anotherDouble = 9.98;
		int anotherInt = (int) anotherDouble; // double zu int
		System.out.println("Double zu Int: "+ anotherInt); // 10
		
		
		// char zu int umwandelen
		
		char myChar = 'Q';
		int charAsInt = (int) myChar; // char zu int
		System.out.println(charAsInt); // 81
		
		
		
		
		
		
	}
	
	

}
