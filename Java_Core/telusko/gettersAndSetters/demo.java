package telusko.gettersAndSetters;
 
//Using getters and setters in this way encapsulates the age property,
//ensuring that age can neither be directly accessed nor modified without validation.
//This encapsulation protects the integrity of the data and is a cornerstone of object-oriented design.

class Human {
    private int age;
    private String name ="navim";

    // by restricting the varibales and object the need for mehtods to acces them is obvious

    public int getAge() {
        // i can acces them because this method  in the same class
        return age;

    }

    public String getName() {
        // i can acces them because this method  in the same class
        return name;

    }

    public void setAge(int a) {
         age = a;

    }

    public void setName(String name) {
        this.name = name;
    }

}

public class demo {
    
    public static void main(String[] args) {
        
        Human obj = new Human();

        obj.setAge(20); 
        //obj.name ="ich";

        System.out.print(obj.getName() + obj.getAge());

    }
}


