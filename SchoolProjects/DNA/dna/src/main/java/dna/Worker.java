package dna;

/**
 * Die Klasse, die einen Mitarbeiter darstellt und als Zwischen Layer dient, die Methoden darstellt und Mitarbeiter Eigenschaften definiert .
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Worker {
    private String firstName;
    private String lastName;
    private String birthDate;

    /**
     * Konstruktor für die Klasse Worker.
     * 
     * @param firstName Der Vorname des Mitarbeiters.
     * @param lastName Der Nachname des Mitarbeiters.
     * @param birthDate Das Geburtsdatum des Mitarbeiters.
     */
    public Worker(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWorkerDetails() {
        return firstName + " " + lastName + ", Geburtsdatum: " + birthDate;
    }
}
