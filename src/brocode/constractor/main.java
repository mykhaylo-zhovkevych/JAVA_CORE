package brocode.constractor;

public class main {
    public static void main(String[] args) {
        
        human Human = new human("rick",65,70);
        human Human1 = new human("morty",65,70);

        Human.eat(); // so simply i can use the object with different methods.
        Human1.drink();
    }
}
