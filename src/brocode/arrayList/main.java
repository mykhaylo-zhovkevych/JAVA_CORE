package brocode.arrayList;

import java.util.ArrayList;

public class main {


public static void main(String[] args) {
    
// ArrayList = a resizable Array.
// ArrayList is a specific implementation of the List interface that uses a dynamically resizable array to store elements.
// Elements can be added and removed after compilation phase store reference data types

ArrayList<String> food = new ArrayList<String>();
food.add("pizza");
food.add("hamburger");
food.add("hotdog");
// ArrayList uses the wrapper class as definer

//methods that often used in arrayList
food.set(0, "sushi");
food.remove(2);
food.clear();


for(int i=0; i<food.size(); i++) {
    System.out.println(food.get(i));

}
    }
}


// Other implementations of List include LinkedList, which uses a doubly-linked list, and Vector, 
// which is similar to ArrayList but is synchronized.