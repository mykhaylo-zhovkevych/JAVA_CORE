package brocode.constractor;



public class human {

    String name;

	int age;

	double Aweight;

	

	human(String name,int age,double Sweight){

		

		this.name = name;
// it is okay to envisage that insted of this. it is actually calling: classname.placeholder outside of  constructor
/*
 * If you don't have class variables like String name;, int age;, and double 
 * Aweight; declared at the class level, and you only have them as parameters in the constructor,
 * then you indeed don't need to use this to reference them. 
 * NOT RECOMMENDED cause: 
 * That's correct. If your variables are only parameters in the constructor and 
 * not declared as class variables (instance variables), they are local variables and will only
 *  be accessible within the scope of that constructor.
 */
		this.age = age;

		this.Aweight = Sweight;

	}

	

	void eat() {

		System.out.println(this.name+" is eating");

	}

	void drink() {

		System.out.println(this.name+" is drinking");

	}

}
/*

Aweight = Sweight;: Assigns the value of the Sweight parameter to the Aweight instance variable.

Purpose:
The primary purpose of this assignment is to initialize the state of the human object with the provided weight value.
 When you create a human object using the constructor, you can customize the initial values of its attributes (name, age, weight) 
 by providing arguments


In this example, "John" is assigned to name, 25 to age, and 70.5 to Sweight.
 The line this.Aweight = Sweight; ensures that the Aweight attribute of the person object is set to 70.5.


the code can be made without constructor but not recomanded.



so the point of declering the variables above the palacve holder is that the variables after creation can be accesed out side the constructor 
so i dont define the variable/placeholders i wont be able to use them outseide the constructor, i will be needing to do someting like this: 

 * public class Human {
    // No class-level variables

    Human(String name, int age, double Sweight) {
        // Local variables within the constructor
        String localName = name;
        int localAge = age;
        double localAweight = Sweight;

        // Accessing local variables within the constructor
        someMethod(localName, localAge, localAweight);
    }

    public void someMethod(String name, int age, double Aweight) {
        // This method can access the parameters passed to it
        // However, it cannot access local variables from the constructor
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Aweight: " + Aweight);
    }
}

this is not practical at all.
otherwise so: 

public class Human {
    // No class-level variables

    Human(String name, int age, double Sweight) {
        // Local variables within the constructor
        String localName = name;
        int localAge = age;
        double localAweight = Sweight;

        // These variables are not accessible outside the constructor
    }

    public void someMethod() {
        // Attempting to use local variables here would result in a compilation error
        // because they are not visible outside the constructor
    }
}




 
 */