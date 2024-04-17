package telusko;


final class Calc {

    public void show() {
        System.out.print("in show");

    }
    public void add(int a, int b)
    {

        System.out.println(a+b);
    }
}
class AdvCalc extends Calc{
// if i need to stop somebody from extending my class 
// i can make my class final so that any inharatence will be not allowed

// if i need to stop from the overring my method by the extended class than i can my method final 

}

public class Final {
    public static void main(String[] args) {
    // the final in the java is the same as in JS const    
  
    //final int num = 8;
    //num = 9;
    //System.out.println(num);
        Calc obj = new Calc();
        obj.add(2,3);

    }

}
