package main.java.prj.multi.sequential;



public class SequentialExecutionDemo {

    public static void main(String[] args) {
        demo01();
        demo02();
    }


    private static void demo01() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Demo01: " + i);
        }
    }

    private static void demo02() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Demo02: " + i);
        }
    }



}