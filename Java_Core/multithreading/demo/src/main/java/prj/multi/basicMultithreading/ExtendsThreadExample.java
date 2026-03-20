package main.java.prj.multi.basicMultithreading;

public class ExtendsThreadExample {
    public static void main(String[] args) {

        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();

        one.start();
        two.start();

    }
}



class ThreadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("ThreadOne: " + i);
        }
    }
}

class ThreadTwo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("ThreadTwo: " + i);
        }
    }
}
