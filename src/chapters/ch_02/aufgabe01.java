

import java.util.Scanner;

/** 2.1
 * Reads Celsius in double value from the console and converts it to Fahrenheit
 */


public class aufgabe01 {
public static void main(String[]args) {
		double Celsius; 
		double Fahrenheit;
		
		System.out.println("Enter degrees in Celsius");
        
		Scanner input = new Scanner(System.in);
		Celsius = input.nextDouble();
		
		Fahrenheit = (9.0/5.0 * Celsius + 32);

		System.out.println(Fahrenheit);
		
		input.close();
	}
}

/** SCANNER

Java Scanner class is part of the java.util package.
 It was introduced in Java 1.5 release.
  The Scanner is mostly used to receive user input and parse them into primitive data types such as int,
   double or default String.
    It’s a utility class to parse data using regular expressions by generating tokens.

Additional Notes:
1. **Error Handling:**
   - The Scanner class provides methods like `hasNextDouble()` or `hasNext()` to check if the input is of the expected type before attempting to read it, aiding in handling potential input errors.

2. **Delimiter Customization:**
   - The Scanner class allows customization of delimiters using the `useDelimiter` method. By default, it uses whitespace as a delimiter, but you can change it to parse input differently.

3. **Closing the Scanner:**
   - It's important to close the Scanner using the `close()` method to release system resources, especially when dealing with console input, to prevent potential resource leaks.

4. **Exception Handling:**
   - Using Scanner for user input might throw exceptions like `InputMismatchException` or `NoSuchElementException`. Consider using try-catch blocks for proper exception handling.

5. **Scanner Constructors:**
   - Besides `System.in`, the Scanner class can be constructed with other sources like `File`, `String`, or `InputStream` objects.


methods: 

    next(): Reads the next token (a sequence of non-whitespace characters) from the input.
    nextLine(): Reads the entire line (until the Enter key is pressed) and returns it as a string.


	nextInt(), nextLong(), nextFloat(), and nextDouble():
    These methods read the next token and parse it into the corresponding primitive type.



	hasNext(), hasNextInt(), hasNextDouble(), etc.:
    These methods check whether the next token or value matches the expected type. Useful for input validation.

	useDelimiter(String pattern):
    Sets a custom delimiter pattern for tokenizing input. By default, whitespace is used.

 */ 

/** Scanner scanner = new Scanner("one,two,three");
scanner.useDelimiter(",");
while (scanner.hasNext()) {
    String token = scanner.next();
    // process each token
}


Scanner scanner = new Scanner("123 abc 456");
scanner.skip("[0-9]+"); // Skips the numeric part
String remaining = scanner.next();
// remaining will be "abc 456"

*/ 