package telusko.Thread;

class Counter {
        int count;
    // to prevent the tread running at the same time and having strange outcome the sychronized keyword can be used to make explicetely one method at one time 
    public void icrement() {
        count++;
    }
}

/* class A implements Runnable {
    public void run() {

    
    }
}

class B implements Runnable {
    public void run() {

        
    }
} */

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

       
        Runnable obj3 = () -> {
                for (int i = 1; i<=1000; i++) {
                
                        c.icrement();
                    }
                };

                Runnable obj2 = () -> {
                    for (int i = 1; i<=1000; i++) {
                    
                            c.icrement();
                        }
                    };

                    /* Runnable obj1 = () -> {
                        for (int i = 1; i<=1000; i++) {
                        
                                c.icrement();
                            }
                        }; */

    Thread t1 = new Thread(obj3);
    Thread t2 = new Thread(obj2);

    t1.start();
    t2.start();

    System.out.println(c.count);

    t1.join();
    t2.join();

    System.out.println(c.count);

    }
}
