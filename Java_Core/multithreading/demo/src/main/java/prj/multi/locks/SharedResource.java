package prj.multi.locks;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int counter = 0;
    private final ReadWriteLock lock = new ReentrantLock();

    public void increment() {
        lock.writeLock().lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + "writes: " + counter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getValue() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "reads: " + counter);
        } finally {
            lock.readLock().unlock();
        }
    }
}

class ReadWriteLockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        for (int i = 0; i <2; i++) {
            Thread readerThread = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    resource.getValue();
                }
            });
            readerThread.setName("Reader Thread " + (i + 1));
            readerThread.start();
        }

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++ ) {
                resource.increment();
            }
        });
        writerThread.setName("Writer Thread");
        writerThread.start();
    }
}

