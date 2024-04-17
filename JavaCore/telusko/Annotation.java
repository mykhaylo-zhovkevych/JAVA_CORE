package telusko;
/*
Annotations in Java are a powerful feature that provide a way to add metadata to Java code. 
Introduced in Java 5, annotations do not directly affect program semantics, 
but they can influence the behavior of a program through the use of tools and libraries.
Here are some common uses and benefits of annotations in Java:
 */

class A {

    public void showTheDataWhichBelongsToThisClass()
    {
        System.out.println("in show A");
    }
}
class B extends A{
    // the method of the A will be overwritten with the method of the B 
    @Override
    public void showTheDataWhichBelongsToThisClass()
    {
        System.out.println("in show B");
    }
}

public class Annotation {
    public static void main(String[] args) {
        
        B obj = new B(); 
        obj.showTheDataWhichBelongsToThisClass();
        
    }
}
