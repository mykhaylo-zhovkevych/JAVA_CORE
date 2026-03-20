package prj.multi.threadSynchronisation;

import javax.management.relation.RelationTypeNotFoundException;

public class LockWithCustomeObjects {

    private static int counter01 = 0;
    private static int counter02 = 1;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment01();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment02();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        System.out.println( counter01 + " -- " + counter02);
    }

    private static void increment01() {
        // So like for accessing counter01 i need to acquire lock1 and for accessing counter02 i need to acquire lock2
        // Decoupling of the locks
        synchronized (lock1) {
            counter01++;
        }
    }

    private static void increment02() {
        synchronized (lock2) {
            counter02++;
        }
    }
}