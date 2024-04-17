package brocode.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample  {
 public static void main(String[] args) {
        // Creating an ArrayList
        List<String> arrayList = new ArrayList<>();

        // Adding elements
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        // Accessing elements
        System.out.println("Element at index 1: " + arrayList.get(1));

        // Iterating through the list
        System.out.println("Elements in ArrayList:");
        for (String language : arrayList) {
            System.out.println(language);
        }
    }
}

/*Size:

    Arrays: Have a fixed size that needs to be declared when the array is created. Once the size is set, it cannot be changed.
    ArrayLists: Can dynamically resize themselves. They can grow or shrink as needed, making them more flexible than arrays.

Type:

    Arrays: Can store both primitive data types (like int, char, etc.) and objects.
    ArrayLists: Can only store objects, not primitive data types. If you want to store primitives in an ArrayList, you need to use their corresponding wrapper classes (e.g., Integer, Character).

Performance:

    Arrays: Generally have better performance for simple operations. They are more memory-efficient and have less overhead.
    ArrayLists: Have some additional overhead due to their dynamic resizing capability, which can impact performance in certain scenarios.

Methods:

    Arrays: Provide only basic functionality and don't have built-in methods for common operations like adding, removing, or searching for elements.
    ArrayLists: Provide a variety of methods for adding, removing, and manipulating elements. They are part of the Java Collections Framework and offer more functionality compared to arrays. */