package telusko.Modifiers.other;

class Launch {

    public void abc () {

        A obj = new A();
        System.out.println(obj.markss);
        // the proctected will work in the same package  
    }
}

public class A {
    // this can be accesed without the public becaue this is in the same package as Demo

    // the private modifier allow to use the variabel or method only in the same class where it was instantiated 
    private int marks = 6;

    public int mark = 6;

    //the default can be accessed in the same package where it was defined    
    // like  int marks = 6;

    protected int markss = 10; 
}
