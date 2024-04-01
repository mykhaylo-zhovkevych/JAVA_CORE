package telusko.constructors_this;
// 5:46:49 / 12:23:22

public class constructors {
    public static void main(String[] args) {
        // when i create the object the object will go to the heap memory and be black object
        // by default the object will be create with blank inod like 0 or null 
        Human obj = new Human();
        Human obj1 = new Human(18, "navim");
    
      //  obj.setAge(54);
      //  obj.setName("hallo");
       
        System.out.print(obj.getName() + obj.getAge());
        System.out.print(obj1.getName() + obj1.getAge());
    }
}
     class Human {

        private int age;
        private String name;

        // this is called default constructor
        public Human() {
            // in this constructor the values can be assigned
            // the constructor will be called when even the constractor is not being called
            // every time i create a new object the construcvtor will be called  
            System.out.print("this is constructor");
            age = 19; // so like by default this constructor will be called 
            // some user case the need for secure connect between the databae and the server can be accomplished through constructo 
            
        }
        // this is Parrameterized constructor
        // difference the differece is that: 
        // 1. Default constructors do not accept any parameters, while parameterized constructors must accept at least one parameter.
        // 2. Default constructors are used for simple object initialization with default values, whereas parameterized constructors are used for initializing objects with specific values or performing complex initialization logic.

        public Human (int a, String n){
            age = a;
            name = n;

        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }


