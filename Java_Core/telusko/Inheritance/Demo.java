package telusko.Inheritance;

class Calc {

    public int add(int n1, int n2)
    {
        return n1 + n2;

    }

    public int sub(int n1, int n2)
    {
        return n1 - n2;

    }
}

public class Demo {
    public static void main(String[] args) {
        
        Demo02 obj = new Demo02();

        int r1 = obj.add(2, 3);
        int r2 = obj.multi(2, 2);
        int r3 = (int) obj.power(4, 3);
        System.out.print(r1 + " " + r2 + " " + r3);

    }
    
}
 // 6:29:59 / 12:23:22
