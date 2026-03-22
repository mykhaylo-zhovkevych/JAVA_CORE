package prj.multi.otherConcepts;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
    private static int count = 0;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private static synchronized void increment() {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++ ) {
                //count++;
                counter.incrementAndGet();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++ ) {
                //count++;
                counter.incrementAndGet();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } 
        System.out.println("Final count: " + counter);
    }
}
