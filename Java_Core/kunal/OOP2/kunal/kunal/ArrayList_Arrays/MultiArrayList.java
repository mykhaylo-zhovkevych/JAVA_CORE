package ArrayList_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> obj = new ArrayList();
        // initialisation part even if initialisation will not be made be default the Arraylist will be null
        for (int i = 0; i < 3; i++){
            obj.add(new ArrayList<>());
        }
        // add part 
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                obj.get(i).add(in.nextInt());
            }
        }
        System.out.println(obj);
    }
}
