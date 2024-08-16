package digitalOcean;

import java.util.Scanner;

// in this java-file will be written the pattern-solwing 


public class Problem04 {

		
		
		public static void main(String[] args) {
			
			pattern1(2);
			space();
			pattern2(3);
			space();
			pattern3(4);
			space();
			
		}
		
		private static void space() {
			System.out.println();
			
		}

		
		static void pattern1(int n) {
			// number of times the line or rows will run 
			for (int row = 1; row <= n; row++) {
				// for every row, run the col
				for (int col = 1; col <= row; col++) {
			
					System.out.print("* ");	
			}
			// when one row is printed, we need to add a newline and do the next line with bigger row and col number	
			System.out.println();
				
		}	
	}
		static void pattern2(int n) {
			
				for (int row = 1; row <= n; row++) {
					for (int col = 1; col <= n; col++) {
						
						System.out.print("*");	
				}
					System.out.println();
							
			}
			
	}
		
		static void pattern3(int n) {
			
			// the input will be give from the parameter
			for (int row = n; row >= 1; row--) {
				
				for (int col = 1; col <= row; col++) {
	                System.out.print("* ");
	            }
	            // Nachdem eine Zeile gedruckt wurde, fügen wir einen Zeilenumbruch hinzu
	            System.out.println();
				
				
			}
		}
		
	
		static void pattern4(int n) { 
			
			for(int row = 1; row <= n; row ++) {
				int totalColsInRow = 234;
				
				for(int col = 1; col <= totalColsInRow; col ++) {
				
					
				}
				System.out.println();
			}
		}
		
		
}
