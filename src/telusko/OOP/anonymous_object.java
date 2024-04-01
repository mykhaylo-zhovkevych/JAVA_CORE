package telusko.OOP;

public class anonymous_object {

    public static void main(String[] args) {
        // local variabel
        int marks;
        marks = 99;
        // Wenn Sie also versuchen, in einer statischen Methode eine innere Klasse zu instanziieren, steht Ihnen keine Instanz der äußeren Klasse zur Verfügung, an die die innere Klasse gebunden werden könnte. Daher der Fehler.
        // anonymous_object outer = new anonymous_object();
        //  A obj = outer.new A();

        A obj; // this called reference creation 
        obj = new A(); // creation of instacne ( new A()) and assignment of the value to obj
         new A(); // this type of object is called anonymous object. One problem that this object will go to the heap and than the quesion arrise how this objet will be reused if he is not having any reference 

        obj.show();
        
        }

   static class A {
        
        public A() {
        
        System.out.print("object created ");
        }
        public void show() {
            System.out.println("in A show");

        }
    }
}

