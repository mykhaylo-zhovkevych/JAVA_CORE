package brocode.staticModifier;

public class Friend {

    String name;
    static int numberOfFriends;
  

    Friend(String name){
        this.name=name;
        numberOfFriends++;
    }

    static void displayFriends() {

        System.out.println(numberOfFriends + " have you");

    }
}

/*Now, when we say "a static variable belongs to the class itself, not to instances of the class,"
 it means that the value of a static variable
 is shared among all instances of the class.
 If you modify the value of a static variable in one object,
  the change is reflected in all other objects of the same class.
 * 
 * further explination in onenote
 */