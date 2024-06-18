package brocode.generics;

public class Intro {
    public static void main(String[] args) {
        
       
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {5.5, 4.4, 3.3, 2.2, 1.1};
        Character[] charArray = {'H','E', 'L', 'L', 'O'};
        String[] stringArray = {"B", "Y", "E"};

    //    displayArray(intArray);
    //  displayArray(stringArray);
    // etc ...


    displayArray(intArray);
    displayArray(stringArray);



    }
    // normaly what i will have to do is like to create some Method that will display eacht type 
    // but this is not really efficcent and not compatible with another types.
/* 
    // e.x:
    public static void displayArray(Integer[] array) {
        for(Integer x : array) {
            System.out.println(x+" ");
        }
        System.out.println();
    }
    // If I now want to have a similar method to dipaly the double, I have to create the another method
    
    //public static void displayArray(String[] array) {
    //    for(String x : array) {
    //        System.out.println(x+" ");
    //    }
    //    System.out.println();
    //} 
    // etc..

*/

// better way of doint it with the generics

    public static <T> void displayArray(T[] array) {

        for(T x : array) {
            System.out.print(x+"");
        }
        System.out.println();
    }


}
