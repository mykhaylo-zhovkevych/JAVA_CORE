package exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {

	public static void main(String [] args) {
		
		try {
			File file = new File("noneexistingfile-txt");
			FileReader fr = new FileReader(file);
			
			
		} catch (IOException e) {
			 System.out.println("Fehler: IOException aufgetreten! " + e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
}
