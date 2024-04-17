package telusko.ExceptionHandling;


public class Demo {
    public static void main(String[] args) {
        
         int i = 20;
         int j = 0;

       /*   int nums[] = new int[5];
         String str = null; */

         // ones it has got like expeption it will jump out of the try catch block.
         try{
            j = 19/i;
          /*   System.out.println(str.length());
            System.out.println(nums[1]);
            System.out.println(nums[4]); */
            if (j == 0) {
               // throw keyword is used to throw the exaptions
               throw new ArithmeticException("i dont waht to print a zero ");
            }
         }
         catch(ArithmeticException e){
         // one way to handel th expetion is like to use the e and if statment and than to define the pattern 
            j = 19/1;
            System.out.print("that is default output " + e);
            // in here can be a llot of thing done, e.g: main DBMS have falled connection and in here can the backup connection restored.  
         }
     /*     catch(ArrayIndexOutOfBoundsException e){
            System.out.println("the array error");
         } */
         // this is good practive to make the perant class at the bottom
         catch(Exception e) {

            System.out.print(e);
         }
         // Exception e handels everthing this exception is the parent class of any another class  

        System.out.println(j);

        System.out.println("Bye ");
    }
}
