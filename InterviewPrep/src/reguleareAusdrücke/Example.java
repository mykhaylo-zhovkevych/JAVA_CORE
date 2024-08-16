package reguleareAusdrücke;

public class Example {

	public static void main (String [] args) {
		
		String input = "  Hello,   World! 123   ";
		
		
		// Schritt 1: Entferne alle Leerzeichen
        String noSpaces = input.replaceAll("\\s+", "");
		
		
		String cleanedInput = noSpaces.replaceAll("[^a-zA-Z0-9]", "");	
		
		
		System.out.println(cleanedInput);
	}
	
	
	
	
	
	
}
