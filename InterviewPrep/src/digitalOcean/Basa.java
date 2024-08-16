package digitalOcean;

public class Basa {

	
	public static void main(String[] args) {
		// Primitive Datentypen auf dem Stack
		
		int zahl = 42;
		double pi = 3.14;
		boolean istWhahr = true;
		
		// Referenzen auf Objekte auf dem Stack, Objekte selbst auf dem Heap
		String name = "Max Musterman";
		Person person = new Person("Anna", 50);
		
		// Methodenaufruf
		int ergebnis = berechneSumme(2,3);
		System.out.println(ergebnis);
		System.out.println(person);
		
	}
	
	// Methode zur Berechnung einer Summe#
	public static int berechneSumme(int a , int b) {
		int summe = a + b;
		return summe;
	}
	
	
}


class Person {
	
	 String name;
	 int alter;
	
	 public Person(String name, int alter) {
			
			this.name = name;
			this.alter = alter;
			
		}
	
	 
	 
	 
	
}


