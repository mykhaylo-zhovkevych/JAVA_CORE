package telusko;

class A {

    int age;

    public void show() {

        System.out.print(" iN SHOW ");
    }

    class B {

        public void config() {

            System.out.print(" in the Config ");
        }
    }
}


public class innerClass {
    public static void main(String[] args) {
        
        A obj = new A();
        obj.show();

        A.B obj1 = obj.new B();
        // A.B just specify that the B bolngs to the A class 
        // the need for asking for obj for to create a new B object, is because the B is non-static und for creating the obj1 it requires the obj first 
        // i can make this also a static so if i do that i will not need to do all this in line 28
        // but the outer class cannot be static only inner
        obj1.config();
    }

}
