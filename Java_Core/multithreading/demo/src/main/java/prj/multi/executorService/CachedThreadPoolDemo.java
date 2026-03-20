package prj.multi.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {

    // Here threads are created as needed by workload, not fixed in advance like newFixedThreadPool(n)
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 1000; i++) {
                service.execute(new TaskOne(i));
            }
        }
    }

}



class TaskOne implements Runnable {
    private final taskId;

    public TaskOne(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task:"+taskId+" is being executed by thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}