package telusko.Thread;

class Z {
}

class A implements Runnable {
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

class B implements Runnable {
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

public class Demo01 {
    public static void main(String[] args) {
        

        Runnable obj1 = new A();
        Runnable obj2 = new B();

        // this can be transformed to the lambda expression because the runnable is functiobalInterface 
        Runnable obj3 = () -> {
                for (int i = 1; i<=100; i++) {
                    System.out.println("good day");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        }
                    }
                };

        // the runnable objst gets passed to tread constructor 
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        

    }
}
