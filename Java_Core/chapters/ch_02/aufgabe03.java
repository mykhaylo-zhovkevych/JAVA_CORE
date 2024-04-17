import java.util.Scanner;
/**
 * 2.6 (Sum the digits in an integer)
 * Write a program that reads an integer between 0 and
 * 1000 and adds all the digits in the integer.
 * For example, if an integer is 932, the sum of all its digits is 14.
 */
public class aufgabe03 {
    public static void main(String[] args) {

        System.out.print("Enter an integer to discover the sum of its digits: ");
        
    // try-with-resources
        try (Scanner input = new Scanner(System.in)) {
            int userNumber = input.nextInt();


            System.out.println(sumDigits(userNumber)); //  This line calls the sumDigits method with userNumber as an argument and prints the result returned by the sumDigits method.
        }
    }
    private static int sumDigits(int a) {

        int sum = 0;
        while (a > 0) {
            // 543= (543 % 10 = 4 )
            sum += (a % 10); // here will be the last numbers adding toghether like first 0 +4 than 4 + 3 and the last 7 + 5 = 12
            // than ther number is still 543 that is why / 10 = 54.3 can no be in Integer that is why 54
            a /= 10;
            
        }
        return sum;
}
}
