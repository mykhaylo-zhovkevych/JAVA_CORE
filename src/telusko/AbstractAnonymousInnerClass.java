package telusko;




abstract class A{

    public abstract void show();
}

/*class B extends A {

    @Override
    public void show() {
        System.out.println("in B Show");
    }
    
}
*/
// the class B is only useful for implementing the show method but for this one method meking the whole class, really worth it?
public class AbstractAnonymousInnerClass {
    
    public static void main(String[] args) {
        
        A obj = new A(){
            // the object created of this anonymous class and not the A 
            public void show() {
                System.out.println("in new Show");
            }
        };
        obj.show();

    }

}
