package exceptions;


/*
 * 
 * Laufzeitausnahmen sind Ausnahmen, die zur Laufzeit auftreten und nicht zur Kompilierzeit überprüft werden. 
 * Sie erben von der Klasse RuntimeException. Da sie nicht zur Kompilierzeit überprüft werden, ist der Entwickler nicht gezwungen, sie in einem try-catch-Block 
 * zu behandeln oder sie in der Methodensignatur mit throws zu deklarieren. Typische Beispiele sind NullPointerException, ArrayIndexOutOfBoundsException und ArithmeticException.
 * 
 * */


public class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            // Beispiel für eine ArithmeticException (Division durch Null)
            int result = 10 / 0; // Dies wirft eine ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Fehler: Division durch Null!");
        }
        
        try {
            // Beispiel für eine NullPointerException
            String str = null;
            System.out.println(str.length()); // Dies wirft eine NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Fehler: NullPointerException aufgetreten!");
        }
    }
}
