package prj.multi.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLockDemo();
    private int shareData = 0;

    public void methodA() {
        lock.lock();
        try {
            sharedData++;
            System.out.println("methodA: sharedData = " + sharedData);
            methodB();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            shareData--;
            System.out.println("methodB: sharedData = " + sharedData);
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(example::methodA).start();
    }
}
