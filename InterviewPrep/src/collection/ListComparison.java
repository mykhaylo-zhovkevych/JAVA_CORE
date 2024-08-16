package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison  {

	public static void main(String [] args) {
		
		// Anzahl der Elemente, die wir hinzufügen werden
		
		int numberOfElements = 100000;
		
		
		
		// Arraylist
		List<Integer> arrayList = new ArrayList<>();
		
		long startTime = System.nanoTime();
		
		for(int i = 0; i < numberOfElements; i++) {
			arrayList.add(i);
		}
		
		long endTime = System.nanoTime();
		System.out.println("Zeit zum Hinzufügen von Elementen zur ArrayList: " + (endTime - startTime) + " ns");
		
		
		startTime = System.nanoTime();
		int middleElement = arrayList.get(numberOfElements /2 );
		endTime = System.nanoTime();
	    System.out.println("Zeit zum Zugriff auf ein Element in der Mitte der ArrayList: " + (endTime - startTime) + " ns");
		
		
		
	 // Entfernen von Elementen aus der ArrayList (von hinten nach vorne)
        startTime = System.nanoTime();
        for (int i = numberOfElements - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("Zeit zum Entfernen von Elementen aus der ArrayList: " + (endTime - startTime) + " ns");

	 
        
        List<Integer> linkedList = new LinkedList<>();
        
        startTime = System.nanoTime();
        
        // Elemente zur LinkedList hinzufügen
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.add(i);
        }

        endTime = System.nanoTime();
        System.out.println("Zeit zum Hinzufügen von Elementen zur LinkedList: " + (endTime - startTime) + " ns");
        
        // Zugriff auf ein Element in der Mitte der LinkedList
        startTime = System.nanoTime();
        middleElement = linkedList.get(numberOfElements / 2);
        endTime = System.nanoTime();
        System.out.println("Zeit zum Zugriff auf ein Element in der Mitte der LinkedList: " + (endTime - startTime) + " ns");

        // Entfernen von Elementen aus der LinkedList (von hinten nach vorne)
        startTime = System.nanoTime();
        for (int i = numberOfElements - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("Zeit zum Entfernen von Elementen aus der LinkedList: " + (endTime - startTime) + " ns");
        
        
	    
	}
	
}
