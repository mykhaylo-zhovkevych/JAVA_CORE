package main.java.prj.multi.basicMultithreading;

public class JoinThreadExample {

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadOne: " + i);
            }
        });
        
        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("ThreadTwo: " + i);
            }
        });

        // This will first be executed because it is in the main thread
        System.out.println("Before executing threads");
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("Done executing threads");
        
    }
}