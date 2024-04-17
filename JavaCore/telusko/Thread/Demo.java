package telusko.Thread;

class Z {
    
}


// for to convert the simple class i can just extend with class: Thread
class A extends Thread {
    public void run() {

        for (int i = 1; i<=100; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {

        for (int i = 1; i<=100; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        

    // normal object can not be executed in asychron with multiple threads
        A obj1 = new A();
        B obj2 = new B();
        System.out.print(obj1.getPriority());
        // range is from 1 upto 10 priority
        // by default every thread will have a normal (5) priority

        /* obj1.setPriority(Thread.MAX_PRIORITY);
        obj2.setPriority(Thread.MIN_PRIORITY); */
        obj1.start();
        obj2.start();


    }
}


