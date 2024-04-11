package telusko;




abstract class A{

    public abstract void show();
    public abstract void config();
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

            @Override
            public void config() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'config'");
            }
        };
        obj.show();

    }

}
