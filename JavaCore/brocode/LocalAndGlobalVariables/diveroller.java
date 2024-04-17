package brocode.LocalAndGlobalVariables;

import java.util.Random;

public class diveroller {

private Random random;
private int number = 0;
// constructor is count as method
diveroller() {
 random = new Random();
roll();

}
void roll() {
number = random.nextInt(6)+1;

System.out.println(number);

}

}
