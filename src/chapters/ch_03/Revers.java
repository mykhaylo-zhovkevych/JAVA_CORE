package chapters.ch_03;

public class Revers {
    public static void main(String[] args) {
        int num = 123;
        int ans = 0;

        while (num > 0) {
            int rem = num % 10;
            num /= 10;
            ans = ans * 10 + rem;
        }

        System.out.println("Reversed number: " + ans); // Output the reversed number
    }
}
/*
    Step 1: Extract last digit (rem = 123 % 10 = 3)
        num becomes 123 / 10 = 12
In the context of reversing a number, this operation effectively removes the last digit from num, leaving the remaining digits for the next iteration of the loop to process.
    Step 2: Building the reversed number (ans = 0 * 10 + 3 = 3)
    Step 3: Extract last digit (rem = 12 % 10 = 2)
        num becomes 12 / 10 = 1
    Step 4: Building the reversed number (ans = 3 * 10 + 2 = 32)
    Step 5: Extract last digit (rem = 1 % 10 = 1)
        num becomes 1 / 10 = 0
    Step 6: Building the reversed number (ans = 32 * 10 + 1 = 321)
 */