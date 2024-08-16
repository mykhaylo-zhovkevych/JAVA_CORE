package interview;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTestInterview {

	/*
	 * Implementieren Sie die Funktion fizzbuzztest, die ein Byte-Array zurückgibt.

Das Array wird nach den folgenden Regeln gebildet:

    Die Funktion nimmt ein Argument in Form einer ganzen Zahl entgegen.
    Wenn die Zahl durch drei teilbar ist, fügen Sie das Wort "Fizz" in das Array ein.
    Wenn die Zahl durch fünf teilbar ist, fügen Sie das Wort "Buzz" in das Array ein.
    Wenn die Zahl durch drei und fünf teilbar ist, fügen Sie das Wort "FizzBuzz" in das Array ein.
    Wenn die Zahl durch keines dieser Kriterien teilbar ist, werfen Sie eine IllegalArgumentException.

Die Lösung muss durch Tests abgedeckt werden.
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	public byte[] fizzbuzztest(int value) {
		
		//List<String> arrayList = new ArrayList<>();
		
		String arrayList;
		
		if (value % 3 == 0 && value % 5 == 0) {
			arrayList = "FizzBuzz";
		}
		else if (value % 3 == 0) {
			arrayList  =" Fizz";
		}
		else if (value % 5 == 0) {
			arrayList = "Buzz";
		}
		else {
			throw new RuntimeException("Not implemenmted yet");
		}
		
	//	String resultString = String.join("", arrayList);
		
		return arrayList.getBytes();
	}
	
	
	
	public static void main (String [] args) {
		
		
		
		FizzBuzzTestInterview obj = new FizzBuzzTestInterview();
		
		
		byte[] result = obj.fizzbuzztest(3);
		System.out.println("Result: " + new String(result));

		
		
	}

	
	
}
