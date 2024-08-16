package javaBook;

import java.util.Scanner;

public class UserInputTaking {

	// 
	public static void main(String[] args) {
		
		// create a Scanner object to read user input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		
		System.out.println("Hi " + name);
	}
	
}
