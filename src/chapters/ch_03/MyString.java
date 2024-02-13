package chapters.ch_03;

import java.util.Scanner;

public class MyString {

    private char[] charArray;

    // Constructor to create MyString from a char array
    public MyString(char[] charArray) {
        this.charArray = new char[charArray.length];
        System.arraycopy(charArray, 0, this.charArray, 0, charArray.length);
    }

    // Constructor to create MyString from user input
    public MyString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        char[] inputChars = scanner.nextLine().toCharArray();
        this.charArray = new char[inputChars.length];
        System.arraycopy(inputChars, 0, this.charArray, 0, inputChars.length);
    }

    // Method to get the length of the MyString
    public int length() {
        return charArray.length;
    }

    // Method to get the character at a specific index
    public char charAt(int index) {
        if (index < 0 || index >= charArray.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return charArray[index];
    }

    // Method to convert MyString to a character array
    public char[] toCharArray() {
        char[] copyArray = new char[charArray.length];
        System.arraycopy(charArray, 0, copyArray, 0, charArray.length);
        return copyArray;
    }

    // Override toString method to provide a custom string representation
    @Override
    public String toString() {
        return new String(charArray);
    }

    // Method to concatenate two MyString objects
    public MyString concat(MyString anotherString) {
        char[] resultArray = new char[this.length() + anotherString.length()];
        System.arraycopy(this.charArray, 0, resultArray, 0, this.length());
        System.arraycopy(anotherString.toCharArray(), 0, resultArray, this.length(), anotherString.length());
        return new MyString(resultArray);
    }

    public static void main(String[] args) {
        // Example using the constructor that takes user input
        MyString userInputString = new MyString();

        // Example usage
        System.out.println("Length: " + userInputString.length());
        System.out.println("Character at index 2: " + userInputString.charAt(2));
        System.out.println("MyString as char array: " + userInputString);

        // Concatenation example
        MyString anotherString = new MyString(new char[]{' ', 'W', 'o', 'r', 'l', 'd'});
        MyString concatenatedString = userInputString.concat(anotherString);
        System.out.println("Concatenated String: " + concatenatedString);
    }
}






