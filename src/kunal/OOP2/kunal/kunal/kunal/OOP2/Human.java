package kunal.OOP2;

public class Human {
int age;
String name;
int salary;
boolean married;
static long population;

public Human (int age, String name, int salary, boolean married) {
    this.age = age;
    this.name = name;
    this.salary = salary;
    this.married = married;
// the static has no connection to the object 
// static varibale are not dependet Objects i can use them witout even any declared inastance of object
    Human.population += 1;
}


}
