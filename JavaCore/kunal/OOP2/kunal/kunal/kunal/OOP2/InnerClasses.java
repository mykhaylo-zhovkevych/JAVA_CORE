package kunal.OOP2;


public class InnerClasses {
// this calss test dependet on the innerCalss ,but wehn it is static it dont depemd of object of the innerCalss
  static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}
// static methods, calsses are resolving during the compile time, because they dont posses any objectas 
// System is class the println is method and out is variable 
// dot bbind instence varibale and instence methods  with reference variabels