package digitalOcean;

import java.util.Scanner;


public class Problem05 {

	
	// the task is to reverse the input string and check if the result is equal to the input
	
	
	
	
	public static void main(String [] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("enter the string");
	String obj = scanner.nextLine();
	String obj01 = "Hello";
		
	System.out.println("you have entered: "+obj);
	
	if (isPalindrome(obj)) {
		
			System.out.println("The string is a palindrom");
		
		}
		else {
			System.out.println("The string is not a palindrom");
		}
	
	}
	
	
	public static boolean isPalindrome(String str) {
		
		String obj = convert(str);
		
		// converts the original String to the reversed
		String reversedObj = new StringBuilder(obj).reverse().toString();
		
		// System.out.println(reversedObj);
		
		// check if the reverses String equal to the input
		return obj.equals(reversedObj);
	}
	
	
	public static String convert(String str) {
		
		// Convert to lowercase and remove non-alphanumeric characters
		return str.toLowerCase().replaceAll("[^a-z0-9]", "");
		
	}
	
	
}
