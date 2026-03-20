package prj.multi.threadSynchronisation;

public class SynchronisationDemo {

    // Bad Example
    // private static int counter = 0;
    // public static void main(String[] args) {

    //     Thread one = new Thread(() -> {
    //         for (int i = 0; i < 10000; i++) {
    //             counter++; // counter = counter + 1;
    //         }
    //     });

    //     Thread two = new Thread(() -> {
    //         for (int i = 0; i < 10000; i++) {
    //             counter++;
    //         }
    //     });

    //     one.start();
    //     two.start();

    //     try {
    //         one.join();
    //         two.join();
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException(e);
    //     }

    //     System.out.println("Counter: " + counter);

    // }    

    public static void main(String[] args) {
    
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
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

        System.out.println("Counter: " + counter);
        
    }
    
    private synchronized static void increment() {
        counter++;
    }

}

/*
 * Race condition: when two or more threads access shared data and they try to change it at the same time. 
 * The thread scheduling algorithm can swap between threads at any time, and because of this, you can get different results each time you run the program.
 * 1. Load
 * 2. Increment
 * 3. Set back the value  
 * counter = 0; incrementValue = 1; Thread 1
 * counter = 0; incrementValue = 1; Thread 2
 */
