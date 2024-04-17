package telusko;


class A {
    public void show1() {

        System.out.print(" in show1 ");

    }

}

class B extends A{
    public void show2() {

        System.out.print(" in show2 ");

    }
}

public class upcastingDowncasting {
    public static void main(String[] args) {
        
        // this concept is upcasting
      //  A obj = (A) new B();
      //  obj.show1();
        // this will not work beacue the parent class dont know that the chld class exist at all: obj.show2();

        A obj = new B();
        obj.show1();

        // this is downcasting 
        B obj1 = (B) obj;
        obj1.show2();



    }
}
