package programmes_excercises.demo.src.main.java.kata.id;

public class MiddleCharacterProblem {
    
    public static String getMiddle(String word) {
        int length = word.length();
        int middle = length / 2;

        // Check if the length is even
        if (length % 2 == 0) {
            // Return the middle 2 characters
            return "" + word.charAt(middle - 1) + word.charAt(middle);
        } else {
            // Return the middle character
            return "" + word.charAt(middle);
        }
    }

    public static void main(String[] args) {
        System.out.println(getMiddle("test"));    // Expected: "es"
        System.out.println(getMiddle("testing")); // Expected: "t"
        System.out.println(getMiddle("middle"));  // Expected: "dd"
        System.out.println(getMiddle("A"));       // Expected: "A"
    }
}