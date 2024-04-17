package ArrayList_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);

        // list.add(67);
        // list.add(673);
        // list.add(23);
        // list.add(1);
     
        // System.out.println(list);
        
        // list.set(0, 99);

        // list.remove(2);

        // System.out.println(list);

        for (int i = 0; i < 5; i++){
            list.add(in.nextInt());
        }
        System.out.println();

        for (int i = 0; i < 5; i++){
            System.out.println(list.get(i));
        }
    }
}
