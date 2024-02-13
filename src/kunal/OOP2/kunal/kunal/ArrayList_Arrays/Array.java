package ArrayList_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Creating a Scanner object for input
        
        String[] str = new String[4]; // Creating an array of String objects with a length of 4

        // Looping through each element of the array
        for (int i = 0; i < str.length; i++) {
            str[i] = in.next(); // Taking input for each element using the Scanner object
        }

        System.out.println(Arrays.toString(str)); // Displaying the contents of the array using Arrays.toString()
        
        in.close(); // Closing the Scanner object
    }
}
