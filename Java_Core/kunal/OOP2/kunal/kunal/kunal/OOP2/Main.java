package kunal.OOP2;

public class Main {

public static void main(String[] args)
/*Static: The main method must be declared as static because it is called by the JVM before any objects of the class are created. 
The static keyword indicates that the method belongs to the class itself rather than to instances of the class. 
This is important because, in the absence of any objects, the JVM needs a way to call the main method directly on the class.*/  
{
    Human kunal = new Human(2, "kuhal", 10000, true);
    Human ruhal = new Human(2, "ruhal", 10000, true);

System.err.println(Human.population);


}


}
