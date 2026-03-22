package prj.multi.concurrentCollection;

import java.util.ArrayList;
import java.util.List;

public class SynchronisedCollcetion {
    public static void main(String[] args) {
        
    //List<Integer> list = new ArrayList<>(); 
    // One way of creating a synchronized collection
    List<Integer> list : Collections.synchronizedList(new ArrayList<>());

    Thread one = new Thread(() -> {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    });

    Thread two = new Thread(() -> {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(list.size());
    }
}