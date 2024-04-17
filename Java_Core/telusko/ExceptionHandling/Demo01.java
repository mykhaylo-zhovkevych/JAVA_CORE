package telusko.ExceptionHandling;

import java.io.*;

// the own exception can be created, but it needs a tool, whether I build the exception(runtime) class or inherit from it is up to me
class MyException extends Exception {

      public MyException(String string) {
         super(string);
      }
}

public class Demo01 {
    public static void main(String[] args) throws MyException {
        
         int i = 20;
         int j = 0;

         try{
            j = 19/i;
   
            if (j == 0) {
               // throw keyword is used to throw the exaptions
               throw new MyException("i dont waht to print a zero ");
            }
         }
         catch(MyException e){
            j = 19/1;
            System.out.print("that is default output " + e);
         }
         catch(Exception e) {
            System.out.println(e);
         }
    }
}

/* The throws keyword is used in the method signature to declare that a method might throw certain exceptions during its execution. Declaring an exception with throws does not throw the 
exception itself—it only signals that the method could throw this exception, leaving it up to the caller of the method to handle it. This is primarily used with checked exceptions, 
which must be either caught or declared to be thrown. Here’s how you use it:
 */
class FileReader {
    public void readFile(String path) throws IOException {
        File file = new File(path);
        FileInputStream stream = new FileInputStream(file);
        // Further file processing code
    }
}
