

import java.util.Scanner;

public class aufgabe01_01 {
public static void main(String[] args) {
		double x ;
		double y ;
		double z ;
		//double z = Math.min(x,  y); // shows minimum value of the x, y
		//double z =Math.abs(y);// shows absolute value of the z
		//double z = Math.sqrt(y); // square root function this is
		//double z = Math.round(x); // this function rounds the comma number
		//option Math.ceil always rounds the number to like 3.1 == 4 and floor will round down number 
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter side X: ");
		x = scanner.nextDouble();
		System.out.println("Enter side Y: ");
		y = scanner.nextDouble();
		
		z =	Math.sqrt((x*x)+(y*y));
		
		System.out.println("the hypotenus is: "+z);
		
		scanner.close();
	// some Method of the Math calls

	}

}
