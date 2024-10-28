package rgb;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scnanner = new Scanner(System.in);
		

		// Accepting user input 
		System.out.println("Enter red input");
		int r = scnanner.nextInt();
		
		System.out.println("Enter green input");
		int g = scnanner.nextInt();
		
		System.out.println("Enter blue input");
		int b = scnanner.nextInt();
		
		
		// Prints the output
		String hexColor = rgb(r,g,b);
		if (hexColor != null) {
			System.out.println("Hexadecimal color: #" + hexColor);
		}
		else 
			System.out.println("invalid user input"); 
	}
	

	
	public static String rgb(int r, int g, int b) {
		
        // Check if the RGB values are valid
        if (r < 0 || g < 0 || b < 0) {
        	return null; 
    	}
        
        r = (r > 255) ? 255 : r;
        g = (g > 255) ? 255 : g;
        b = (b > 255) ? 255 : b;
        

        // Convert the RGB values to hexadecimal
        String hex = String.format("%02X%02X%02X", r, g, b);
        return hex;
    }
}
