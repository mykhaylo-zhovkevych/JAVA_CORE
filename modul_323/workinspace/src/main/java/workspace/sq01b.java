package workspace;

import java.util.List;
import java.util.stream.IntStream;

public class sq01b {

	// Es soll eine Liste von Integer von 0 bis 100 mit Hilfe von IntStream.range() erstellt werden.
	
	public static void main(String[] args) { 
		
		// Die ntStream ist kein Objket, sondern eine spezieller Stream-Typ, der Teil der Java Steream API ist.
		List<Integer> numbers = IntStream
				.range(0, 101)
				.boxed()
				.toList();
		
		System.out.println(numbers);
		
		
		filterNumbers(numbers,2).forEach(i -> System.out.println(i+" "));
		System.out.println();
		
		filterNumbers(numbers,10).forEach(i -> System.out.println(i+" "));
		System.out.println();
	}
	
	public static List<Integer> filterNumbers (List<Integer> numbers, int divisor) {
		
		return numbers
				.stream()
				.filter(number -> number % divisor == 0 )
				.toList();	
	}
}


//import java.util.stream.IntStream;
//
//public class IntStreamExample {
//    public static void main(String[] args) {
//        // Erstellen eines IntStream von 0 bis 100 (exklusive 101)
//        IntStream intStream = IntStream.range(0, 101); // 0 bis 100
//
//        // Ausgabe der Zahlen im Stream
//        intStream.forEach(System.out::println);
//    }
//}
