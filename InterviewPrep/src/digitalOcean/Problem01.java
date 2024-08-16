package digitalOcean;

public class Problem01 {
	
	
	// What i need 
	// input 
	// output already  
	// method for reversing the input
	// what the Method have to do 
	// first it must be able to recive
	// it has to return the reversed input
	// what i can do i can create error checker if the input are valid 
	// i can create object that give new output Text ===> what i need fot that new Stringbuilder
	// how to make the input reversiable?
	// make char array that converts the input ot chars
	// now make loop that starts from the back and build new obj 
	// make out.append(arr[i])
	// return it and make it toString();
	// end
	
	
	
	public static void main(String [] args) {
		/*
		 * There is no reverse() utility method in the String class. 
		 * 1. However, you can create a character array from the string and then 2. iterate it from the end to the start. 
		 * You can append the characters to a Stringbuilder and finally return the reversed string.
		 * 
		 * */
		
		// Input
		String input = "ilikepizza";
		System.out.println(reverse(input));
	}
	
	
	//
	public static String reverse(String in) {
		if (in == null )
			throw new IllegalArgumentException("Null is not allowed");
			
		StringBuilder out = new StringBuilder ();
		
		char [] arr = in.toCharArray();
		// this int i = arr.length -1 is actually just getting the max number - 1 this - 1 is because of the array it starts from the 0 and not from 1 so that will give the last element 
		// es muss array die i ist grösser und gleich als 0 wenn es -1 dann es out of the array boundaries 
		// und es soll rekursive sein also nach hinten
		for (int i = arr.length - 1; i >= 0; i--)
			out.append(arr[i]);
		
		// (StringBuilder ist kein String)
		return out.toString();
	}
}
