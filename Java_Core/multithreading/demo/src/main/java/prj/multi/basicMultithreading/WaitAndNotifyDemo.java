package prj.multi.basicMultithreading;

public class WaitAndNotifyDemo {


    private static final Onject LOCK = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }

        });

        one.start();
        two.start();
    }
    // wait/notify is interrupteble
    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method one");
            LOCK.wait();
            System.out.println("hello again from method one");
        }
    }

    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method two");
            // it does not right away release the lock, but it will release the lock after the synchronized block is executed, namely the next instractions such as System.out....
            LOCK.notify();
            System.out.println("hello from method two even after notifying");
        }
    }

}