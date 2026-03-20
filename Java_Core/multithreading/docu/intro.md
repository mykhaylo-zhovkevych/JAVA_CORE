# Intro 
multithreading is the ability of the cpu to perform different tasks concurrently

## Concurency
- Concurrency: multiple tasks are in progress during the same time period (they may take turns).

## Parallelism
- Parallelism: multiple tasks are executing at the exact same moment (simultaneously on different cores/CPUs).

Quick intuition:
- Concurrency is about structure and coordination.
- Parallelism is about actual simultaneous execution and speedup.
One CPU core can run many threads concurrently via context switching.
Multiple CPU cores can run threads in parallel at the same time.

## Process and Threads
_Process_ is an instance of program execution. When you enter an application, it's a process. The OS assigns it's own Stack & Heap memory area.
_Thread_ is a lightweight process. It is a unit of execution within a given program. A single process may contain multiple threads. Each thread in the process shares the memory and resources.

### Implementing Runnable vs Extending Thread class
_Which approach is better?_
    If I extend Thread then I can't extend any other class, usually a big disadvantage.
    However, a class may implement more than one interface, so which using Implements Runnable approach there is no restriction to extension of class now or in the future.

## Thread types
In java threads are mainly of two types: `User threads` and `Daemon threads`.

User thread:
    Represents important work your program must finish.
    JVM keeps running as long as at least one user thread is alive.
    Examples: main business logic, request handling, file processing.
Daemon thread:
    Background/helper thread for supporting tasks.
    JVM does not wait for daemon threads when all user threads are done.
    They are stopped automatically when the last user thread ends.
    Examples: garbage collector, background cleanup, monitoring.

_User threads keep the app alive._
_Daemon threads do not._

When the user thread finishes, the JVM checks:
    “Are there any non-daemon (user) threads left?”
    If NO → JVM shuts down immediately
    All daemon threads are killed instantly

``` java

public class DaemonUserThreadDemo {
    public static void main(String[] args) {
        Thread backgroundThread = new Thread(new DaemonHelper());
        Thread userThread = new Thread(new UserThreadHelper());
        backgroundThread.setDaemon(true);

        backgroundThread.start();
        userThread.start();
    }
}

class DaemonHelper implements Runnable {
    @Override
    public void run() {
        int count = 0;
        // 8 minutes == 500 secounds
        while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon helper running...");
        }
    }
}

class UserThreadHelper implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread done with execution");
    }
}

```

### Thread Priority

Thread priority in Java is a hint to the `scheduler` about which thread should get CPU time first.

Range: 
- `Thread.MIN_PRIORITY` = 1
- `Thread.NORM_PRIORITY` = 5
- `Thread.MAX_PRIORITY` = 10

Meaning:
- Higher priority thread is more likely to run before lower priority ones.
- it is not guaranteed.
- Behavior can differ by OS/JVM implementation.



