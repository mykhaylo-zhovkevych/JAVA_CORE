package telusko.ExceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static void main(String[] args) throws IOException {
        System.out.println("hallo");
        /* int num = System.in.read(); */
        // read gives the asci value of the code 
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        /* System.out.print(num); */
        try {
            int num = Integer.parseInt(bf.readLine());
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }
    }
}
