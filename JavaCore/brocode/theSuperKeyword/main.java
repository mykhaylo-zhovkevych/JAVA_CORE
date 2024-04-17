package brocode.theSuperKeyword;

public class main {

    public static void main(String[] args) {
        
        // super = keywoard refers to the superclass (parent) of a object
        // very similar to the "this" keyword
        hero Hero = new hero("Batman", 123, "$$$");

        System.err.println(Hero.toString());

    }
}
