/* 
 * An array is a data structure that holds a collection of items, typically of the same type, in a sequential and indexed manner. 
 * This means that each item in the array can be accessed using a numerical index, starting from zero.

Imagine you have a row of boxes, and each box is numbered starting from zero. 
You can put an item in each box and later retrieve it using the box's number. This is essentially how an array works.
 * 
 */

public class ArrayExample {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = {5, 3, 8, 6};

        // Access and print the elements of the array
        System.out.println("First element: " + numbers[0]); // Outputs 5
        System.out.println("Second element: " + numbers[1]); // Outputs 3
        System.out.println("Third element: " + numbers[2]); // Outputs 8
        System.out.println("Fourth element: " + numbers[3]); // Outputs 6

        // Modify an element in the array
        numbers[2] = 10; // Change the third element to 10

        // Print the modified array
        System.out.println("Modified third element: " + numbers[2]); // Outputs 10
    }
}
/* Explanation of the Code

    Declaration and Initialization: The array numbers is declared and initialized with four integers: 5, 3, 8, and 6.

    Accessing Elements: You can access elements in the array using their index. For example, numbers[0] accesses the first element, which is 5.

    Modifying Elements: You can also modify elements in the array by assigning new values to specific indices. For example, numbers[2] = 10 changes the third element from 8 to 10.

    Output: The System.out.println statements print the elements of the array before and after modification.

This simple example shows how to work with arrays in Java, demonstrating how to create, access, and modify elements within an array. */