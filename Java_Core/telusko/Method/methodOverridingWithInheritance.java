package telusko.Method;

import java.security.PublicKey;

class A {
   
public void show()
    {
    System.out.println("in A show");
    }

public void config () 
{
    System.out.print("in A Config");
}


}

class B extends A {
//in the java i can overridethe metho that is in one class 
// the preference will be given to the method that is extends another class    
public void show () 
{
    System.out.println("in B show");
}

}

public class methodOverridingWithInheritance {

    public static void main(String[] args) {
        
        B obj = new B();
        obj.show();
        obj.config();

    }
}
