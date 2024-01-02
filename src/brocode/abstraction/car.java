package brocode.abstraction;

public class car extends vehicle{

    // here is i override the method and give my own implementation to the method that i uses in this class
    @Override
    public void go() {
        System.out.println("driver is driving the car");
    
        //throw new UnsupportedOperationException("Unimplemented method 'go'");
    }

}
