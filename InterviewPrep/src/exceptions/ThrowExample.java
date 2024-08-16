package exceptions;

public class ThrowExample {
    public static void main(String[] args) {
        // Versuch, das Alter zu validieren
        validateAge(15); // Dies wird eine IllegalArgumentException auslösen
    }

    public static void validateAge(int age) {
        if (age < 18) {
            // Eine IllegalArgumentException auslösen, wenn das Alter unter 18 ist
            throw new IllegalArgumentException("Das Alter muss mindestens 18 Jahre betragen.");
        }
        System.out.println("Alter ist gültig: " + age);
    }
}
