package brocode.arrayList;

import java.util.LinkedList;
import java.util.List;

public class List01 {


/**
 * @param args
 */
public static void main(String[] args) {
        // Creating a LinkedList
        List<String> linkedList = new LinkedList<>();

        // Adding elements
        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("C++");

        // Accessing elements
        System.out.println("Element at index 1: " + linkedList.get(1));

        // Iterating through the list
        System.out.println("Elements in LinkedList:");
        for (String language : linkedList) {
            System.out.println(language);
        }
    }

}

/*    
ArrayList is generally faster for random access and 
iteration since it uses an array data structure, allowing constant-time access to elements.
LinkedList can be more efficient for frequent insertions and removals in the middle of the list,
as it involves updating pointers rather than shifting elements.
*/ 

/*Use ArrayList when:

    Random Access and Iteration:
        If you need fast and efficient random access to elements or frequent iteration over the elements, ArrayList is a better choice. Accessing elements by index in an array is a constant-time operation.

    Memory Efficiency:
        ArrayList tends to be more memory-efficient compared to LinkedList because it uses a contiguous block of memory to store elements.

    Single-Threaded Applications:
        If your application is single-threaded and does not require synchronization, ArrayList is a good choice.

Use LinkedList when:

    Frequent Insertions and Deletions:
        If you need to frequently add or remove elements in the middle of the list, LinkedList can be more efficient. Insertions and deletions in a linked list involve updating pointers, which is faster than shifting elements in an array.

    Memory Overhead is Acceptable:
        LinkedList has higher memory overhead compared to ArrayList due to the storage of additional pointers for each element. If memory overhead is not a critical concern, LinkedList can be considered.

    Non-Sequential Access:
        If your access pattern is mostly non-sequential, meaning you perform a lot of insertions and removals in the middle of the list, LinkedList might be a better fit.

    Thread-Safe Operations:
        If thread safety is required, consider using LinkedList or other synchronized collections, as ArrayList is not inherently thread-safe.

Considerations for Other Implementations:

    Vector:
        If you need a synchronized list (thread-safe), you might consider using Vector. However, be aware that the synchronization comes with a performance cost.

    CopyOnWriteArrayList:
        If you need a thread-safe list with low contention on writes and high contention on reads, CopyOnWriteArrayList can be a good choice. It provides thread safety by creating a new copy of the underlying array whenever an element is modified. */