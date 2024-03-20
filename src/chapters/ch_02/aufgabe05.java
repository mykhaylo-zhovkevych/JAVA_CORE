public class aufgabe05 {

    static class Employee {
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getDetails() {
            return "Name: " + name + ", Age: " + age;
        }
    }

    public static void main(String[] args) {
        // Static typing - data type specified
        Employee newInstance = new Employee("John", 25);
        System.out.println(newInstance.getDetails());

        // This would cause a compilation error
        // john = "Invalid"; // Uncommenting this line would result in a compile-time error
    }
}

