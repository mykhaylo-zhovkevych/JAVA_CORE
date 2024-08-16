package collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {
	
	Queue<Integer> priorityQueue = new 	PriorityQueue<>();
	
	
	// Elemente zur PriorityQueue hinzufügen
    priorityQueue.add(10);
    priorityQueue.add(20);
    priorityQueue.add(5);
    priorityQueue.add(15);
    
    
    // PriorityQueue ordnet Elemente nach ihrer natürlichen Ordnung
    System.out.println("Elemente in der PriorityQueue (ungeordnet): " + priorityQueue);
	
    /*
     * Element Entfernen und Zurückgeben: Die Methode poll() entfernt das Element mit der höchsten Priorität 
     * (oder das erste Element in einer regulären Queue) aus der Warteschlange und gibt es zurück.
     * 
     * */
    
    
	// Elemente in sortierter Reihenfolge entfernen und anzeigen
  //  System.out.println("Elemente in sortierter Reihenfolge:");
  //  while (!priorityQueue.isEmpty()) {
  //  System.out.println(priorityQueue.poll());
        
        
    //	}
    
    System.out.println("Aus der PriorityQueue entfernt: " + priorityQueue.poll()); // 5 (kleinstes Element)
    System.out.println("Nächstes Element: " + priorityQueue.peek()); // 10
    
    
 // Weitere Elemente entfernen
    priorityQueue.poll(); // 10
    priorityQueue.poll(); // 15
    priorityQueue.poll(); // 20
    
    System.out.println("Ist die PriorityQueue leer? " + priorityQueue.isEmpty()); // true
    
	}
}
