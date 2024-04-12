package telusko.Interface;


/* @FunctionalInterface
interface A {

int add(int i, int j);

}


public class LambdaWithReturn {
public static void main(String[] args) {
    A obj = new A()
    {
        public int add(int i, int j)
        {
            return i + j;
        }
    };
    int result = obj.add(4, 3);
    System.out.print(result);

}
}
 */
/* @FunctionalInterface
 interface A {

    int add(int i, int j);
    
    }
    
    
    public class LambdaWithReturn {
    public static void main(String[] args) {
        A obj = (int i, int j) ->
            {
                return i + j;
            };
        
        int result = obj.add(4, 3);
        System.out.print(result);
    
    }
} */

@FunctionalInterface
 interface A {

    int add(int i, int j);
    
    }
    
    public class LambdaWithReturn {
    public static void main(String[] args) {
        A obj = (int i, int j) -> i + j;
            
        
        int result = obj.add(4, 3);
        System.out.print(result);
    
    }
}