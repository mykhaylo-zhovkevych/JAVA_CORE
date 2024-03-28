package telusko.Modifiers;

public class demoThis {
    
    public static void main(String[] args) {
            
        Human obj = new Human();

        obj.setAge(20, obj) ; 
        obj.setName("mike");
        //obj.name ="ich";

        System.out.print(obj.getName() + obj.getAge());


         }
    }

    class Human {
        // this age and name is instance variables 
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
        // this a varibale is local varibale 
        // if i what to make this local and instance varibale age and a in the brakces and in the block than
        public void setAge(int age, Human obj) {
            // this obj1 will get adress 101 and than this obj1 is refered by obj
            Human obj1 = obj; 
            // the parameter age is a local variable to the setAge method, and it shadows the instance variable age. When i perform age = age;
            // tis age may be instnace and local 
            obj1.age = age; // output will be 0 because this varibale is assigning the value to itself
            // if i want to emphasize that this varibale shoud not be seen as the local varibael i can make this. to say explicetely that it is istance variable

            // ----------------------------------------

            //this is key word that calls the current that represents the currect object 
            //this ==> the objet that is calling the method
            // VISUALIZATION like here object: 
            //Human obj = new Human();
            // and this obj is calling this method setAge(20); 
            // and this (this.) is reference to the current objet that uses the method like obj.setAge(20); obj is used by the method so the this will be referenced to the (this.)

        }
    
        public void setName(String name) {
            this.name = name;
        }
    
    }



