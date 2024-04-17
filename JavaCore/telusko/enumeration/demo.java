package telusko.enumeration;



/*In Java, an enum (short for enumeration) is a special type that enables for the definition of a fixed set of constants. enum improves type safety, makes it easier to use, and makes your code more readable. */

/*
    Type Safety: Enums ensure that a variable can only take one out of a small set of possible values. This check is done at compile time, reducing errors.

    Fixed Set of Constants: Enums are ideal when you know all possible values of a variable at compile time, like days of the week, months of the year, the planets in the solar system, etc.

    Methods and Fields: Unlike traditional enumerations in other languages, Java's enum can contain fields, methods, and constructors. The constructors are called automatically when an enum is initialized. 
 */
// in java this enum is the class and all this: Running, Failed, Pending, Successs; are objects. 


// the enum can not be extendend with any another class 
 enum Status {
    Running, Failed, Pending, Successs;

 }
public class demo {
    public static void main(String[] args) {
        
        	//Status s = Status.Running;
            //System.out.println(s.ordinal());
            Status [] ss = Status.values();

            for(Status s : ss ){
                System.out.println(s);
            }
            System.out.println(ss[0]);

    }
}

