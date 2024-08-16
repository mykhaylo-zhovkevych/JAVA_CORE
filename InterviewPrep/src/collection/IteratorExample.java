package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        // Create an ArrayList of String objects
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        // Get the iterator
        Iterator<String> iterator = fruits.iterator();

        // Iterate through the collection using the iterator
        while (iterator.hasNext()) {
        	System.out.println(iterator.next());
        	fruits.add("Four");  
       //     String fruit = iterator.next();
          //  System.out.println(fruit);
        	/*
        	 * 
        	 * When you run this code, it will throw a 
        	 * ConcurrentModificationException because the list is modified while it's being iterated.
        	 * */
        	
        }
    }
}
