package prj.multi.concurrentCollection;

import java.util.concurrent.CountDownLatch;

public class Restaurant {

    public static void main(String[] args) {
        int numberOfChefs = 3;
        CountDownLatch latch = new CountDownLatch(numberOfChefs);

        new Thread(new Chef("Chef A","Pasta" ,latch)).start();
        new Thread(new Chef("Chef B","Pizza" ,latch)).start();
        new Thread(new Chef("Chef C","Salad" ,latch)).start();

        latch.await(); // waits for all chefs to finish

        System.out.println("All dishes are ready. Serving the customers!");

    }
}

class Chef implements Runnable {
    private final String name;
    private final String dish;
    private final CountDownLatch latch;
    
    public Chef(String name, String dish, CountDownLatch latch) {
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is preparing " + dish);
            Thread.sleep(2000); // cooking chef
            System.out.println(name + " has finished preparing " + dish);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}