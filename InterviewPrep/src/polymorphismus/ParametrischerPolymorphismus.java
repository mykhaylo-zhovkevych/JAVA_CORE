package polymorphismus;

import java.util.Arrays;
//eine generische Klasse Box, die mit jedem Typ T arbeiten kann



// Box
public class ParametrischerPolymorphismus <T> { // T ist ein Typ-Parameter. Er kann jeden Referenztyp (wie Integer, String, Double, etc.) annehmen.

	private T inhalt;
	
	public void setInhalt(T inhalt) { // Diese Methode akzeptiert ein Objekt vom Typ T, das später durch den tatsächlichen Datentyp ersetzt wird.
		 this.inhalt = inhalt;
		
		
	}
	
	public T getInhalt() {
		
		return inhalt;
	}
	
	
	// Neben generischen Klassen könne auch einzelne Methoden generisch sein
	public static <T> void swap(T[] array, int a, int b) {
		T temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		
	}
	
	
	public static void main(String [] args ) {
		// Box
		ParametrischerPolymorphismus<Integer> integerBox = new ParametrischerPolymorphismus<>();
		integerBox.setInhalt(123);
		System.out.println("Inhalt der Integer-Box: " + integerBox.getInhalt());
		 
		 
		ParametrischerPolymorphismus<String> stringBox = new ParametrischerPolymorphismus<>();
		stringBox.setInhalt("Hallo");
		System.out.println("Inhalt der String-Box: " + stringBox.getInhalt());
		
		
		Integer[] intArray = {1,2,3,4,5};
		 System.out.println("Vor dem Swap: " + Arrays.toString(intArray));
		swap(intArray, 0, 2);
		System.out.println("nach generische methode: " + Arrays.toString(intArray));
		
		
		int[] zahlen = {1, 2, 3, 4, 5};
		System.out.println(zahlen);
		String zahlenAlsString = Arrays.toString(zahlen);
		System.out.println(zahlenAlsString); // Ausgabe: [1, 2, 3, 4, 5]

		
		
	}

	
}
