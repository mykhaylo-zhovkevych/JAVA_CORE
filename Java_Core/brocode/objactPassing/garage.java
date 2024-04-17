package brocode.objactPassing;

public class garage {

/**
 * @param Car
 */
void park(car Car) {
System.out.println("the"+ Car.localname+"is parked  at the garage");

}


}
/*
 * In Java, object passing typically involves passing references to objects as arguments
 *  to methods or constructors. This means that when
 *  you pass an object to a method or constructor, you are passing a reference to the actual object, not a copy
 *  of the object itself. As a result, changes made to the object within the method or constructor
 *  are reflected outside the method or constructor.
 * 
 */