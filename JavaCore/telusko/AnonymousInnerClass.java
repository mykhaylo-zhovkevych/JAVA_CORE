package telusko;

class A {

    public void show() {
        System.out.println(" in show A ");

    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {

        // this is called inner class 
        A obj = new A(){

            public void show() {
                System.out.println(" in new show A ");
        
            }
        };
        // so like waht in this brackets will be executed but not what is in the class itself 
        obj.show();


    }
}
