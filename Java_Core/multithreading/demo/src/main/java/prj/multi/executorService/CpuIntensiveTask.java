package main.java.prj.multi.executorService;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensiveTask {

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: "+cores);

        ExecutorService service = Executors.newFixedThreadPool(cores);
        System.out.println("Created thread pool with :" + cores + " threads");

        for (int i = 0; i < 20; i++) {
            service.execute(new CpuTask());
        }
    }

}


class CpuTask implements Runnable {
    @Override
    public void run() {
        System.out.println("CPU intensive task is being executed by thread "+Thread.currentThread().getName());
    }
}