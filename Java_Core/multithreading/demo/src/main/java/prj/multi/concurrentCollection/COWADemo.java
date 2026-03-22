package prj.multi.concurrentCollection;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWADemo {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }
}

class Simulation {
    private final List<Integer> list;

    public Simulation() {
        this.list = new CopyOnWriteArrayList<>();
        // asList mutable data
        // Array.Of immutable data
        this.list.addAll(Arrays.asList(1, 2, 3, 4, 5));
    }

    public void simulate() {
        Thread one = new Thread(new WriteTask(this.list));
        Thread two = new Thread(new WriteTask(this.list));
        Thread three = new Thread(new WriteTask(this.list));
        Thread four = new Thread(new ReadTask(this.list));

        one.start();
        two.start();
        three.start();
        four.start();

    }
}

class ReadTask implements Runnable {
    private final List<Integer> list; 

    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override public void run()
    {
        while (true) {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
    }
}

class WriteTask implements Runnable {
    private final List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override 
    public void run()
    {
        while (true) {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.set(random.nextInt(list.size()), random.nextInt(10));

    }
}