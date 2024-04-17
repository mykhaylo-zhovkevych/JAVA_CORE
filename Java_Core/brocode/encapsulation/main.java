package brocode.encapsulation;

public class main {
public static void main(String[] args) {
    car Car = new car("BMW", "X5", 2010);

    Car.setYear(2002); 

    System.out.println(Car.getMake());
    System.out.println(Car.getYear());
}
}
