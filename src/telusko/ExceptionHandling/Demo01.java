package telusko.ExceptionHandling;

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
