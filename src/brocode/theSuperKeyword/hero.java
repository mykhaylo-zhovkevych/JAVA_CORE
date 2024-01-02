package brocode.theSuperKeyword;

public class hero extends person{

    String power;
    
    hero(String N, int i, String power){
        super(N,i);
        this.power = power;


    }
    public String toString(){
        return super.toString()+this.power;
}
}
// since the name and age was decaled in the person class this should be assign in constructor of that class