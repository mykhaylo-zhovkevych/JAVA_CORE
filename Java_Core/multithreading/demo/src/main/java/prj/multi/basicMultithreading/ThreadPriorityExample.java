package main.java.prj.multi.basicMultithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        System.out.println(Thread.currentThread().getPriority());

        // main Thread has a 5 Priority
        // and here I change to the 10

        System.out.println(Thread.currentThread().getName() + " says Hi");

        Thread one = new Thread(() -> {
            System.out.println("Thread one says HI as well");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();

        // In this example main thread will be executed
        // because After one.start(), both threads are runnable, and the OS/JVM scheduler decides who gets CPU next. Often main continues immediately because it is already running.

        // If you want deterministic order, use synchronization, not priority. For example:
        Thread one = new Thread(() -> {
            System.out.println("Thread one says HI as well");
        });

        one.start();
        one.join(); // wait until thread one finishes

        System.out.println(Thread.currentThread().getName() + " says Hi");
    }
}
