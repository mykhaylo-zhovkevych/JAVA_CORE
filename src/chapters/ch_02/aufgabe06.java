

import java.util.Scanner;

public class aufgabe06 {
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     boolean end = Armstrong(n);
     System.out.println(end);
}

static boolean Armstrong(int n){
    int Original = n;
    int sum = 0;

    
    
    while (n > 0) {
        int rem = n % 10;
        n = n / 10;
        sum = sum + rem*rem*rem; 
    }
    if (sum == Original){
        return true;
    }
    if (sum != Original){
        return false;
    }
    
    return false;
    
    


}


}
 