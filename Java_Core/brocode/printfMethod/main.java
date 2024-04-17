package brocode.printfMethod;

public class main{
    public static void main(String[] args) {

        // printf() = 	an optional method to control, format, and display text to the console window
		//				two arguments = format string + (object/variable/value)
		//				% [flags] [precision] [width] [conversion-character]

        boolean myBoolean = true; //"%b" and the name of variable
		char myChar = '@'; // %c and the name of variable
		String myString = "Bro"; // %s and the name of variable
		int myInt = 50; // %d and the name of variable
		double myDouble = 1000; // %f and the name of variable
    
        System.out.printf("this is format string\n"); 
        System.out.printf("Hello %10s",myString);
    }
}



// [conversion-character]

		//System.out.printf("%b",myBoolean);

		//System.out.printf("%c",myChar);

		//System.out.printf("%s",myString);

		//System.out.printf("%d",myInt);

		//System.out.printf("%f",myDouble);

		

		//[width]

		// minimum number of characters to be written as output

		//System.out.printf("Hello %10s",myString);

		

		//[precision]

		// sets number of digits of precision when outputting floating-point values

		//System.out.printf("You have this much money %.1f",myDouble);

		

		// [flags]

		// adds an effect to output based on the flag added to format specifier

		// - : left-justify

		// + : output a plus ( + ) or minus ( - ) sign for a numeric value

		// 0 : numeric values are zero-padded

		// , : comma grouping separator if numbers > 1000

		

		//System.out.printf("You have this much money %,f",myDouble);
