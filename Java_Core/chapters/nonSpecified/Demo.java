package chapters.nonSpecified;

 class SimpleObject 
{
    //variables
    //int a;
    //methods  
    public int add(int n1, int n2)
    {
        int r = n1 + n2;
        return r;

    }

}

public class Demo
{
    public static void main(String a[] )
    {
        
        int num1=4;
        int num2=5;
    // request to JVM cause the need for the object exist and variable calc is assigned variable to that object 
        SimpleObject calc = new SimpleObject();
    // this num1 and num2 will be assigned to the add method inside of n and n2 
        int result = calc.add(num1, num2);

        System.out.println(result);

    }

}