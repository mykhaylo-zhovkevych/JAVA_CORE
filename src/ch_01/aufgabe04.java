package ch_01;

/**
 * 1.10 (Average speed in miles) Assume a runner runs 14 kilometers in 45 minutes and 30
 * seconds. Write a program that displays the average speed in miles per hour. (Note
 * that 1 mile is 1.6 kilometers.)
 */


public class aufgabe04 {
/**
 * @param args
 */
public static void main(String[] args) {
    
    double numMiles = 14 / 1.6;
    double speed = numMiles / (45.5 / 60);

    System.out.printf("%.3f", speed);

    
    }
}
