package main.java.prj.multi.basicMultithreading;


public class RunnableThreadExample {

    public static void main(String[] args) {

        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        Thread threadThree = new Thread(() ->{
            for (int i = 0; i < 20; i++) {
                System.out.println("ThreadThree: " + i);
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}    
    
class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("ThreadOne: " + i);
        }
    }
}


class ThreadTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("ThreadTwo: " + i);
        }
    }
}