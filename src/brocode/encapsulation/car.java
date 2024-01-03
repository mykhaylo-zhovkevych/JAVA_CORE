package brocode.encapsulation;

public class car {
// Encapsulation = attributes of a class will be hidden or private,
//Can be accessed only through methods (getters & setters)
// You should make attributes private if you don't have a reason to make therm public or protected

private String make;
private String model;
private int year;

car(String make, String madel, int year){
this.setMake(make);
this.setModel(madel);
this.setYear(year);
}





    /**
     * @return String return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return String return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

}
