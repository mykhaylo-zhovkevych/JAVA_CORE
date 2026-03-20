package threading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private String sharedResource = "Initial Data";

    // Methode für Leseoperation
    public String read() {
        rwLock.readLock().lock();  // Lesesperre aktivieren
        try {
            System.out.println(Thread.currentThread().getName() + " liest: " + sharedResource);
            return sharedResource;
        } finally {
            rwLock.readLock().unlock();  // Lesesperre freigeben
        }
    }

    // Methode für Schreiboperation
    public void write(String data) {
        rwLock.writeLock().lock();  // Schreibsperre aktivieren
        try {
            System.out.println(Thread.currentThread().getName() + " schreibt: " + data);
            sharedResource = data;
        } finally {
            rwLock.writeLock().unlock();  // Schreibsperre freigeben
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();

        // Startet mehrere Lesethreads
        Runnable readTask = example::read;
        for (int i = 0; i < 3; i++) {
            new Thread(readTask, "Reader-" + i).start();
        }

        // Startet einen Schreibthread
        Runnable writeTask = () -> example.write("Neue Daten");
        new Thread(writeTask, "Writer").start();
    }
}
