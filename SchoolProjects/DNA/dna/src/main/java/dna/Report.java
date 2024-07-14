package dna;

/**
 * Klasse, die einen Bericht darstellt und als Zwischen Layer dient, die Methoden zum Zugang von Eigenschaften bereitstellt und den Briefinhalt definiert.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Report {
    private int identNumber;
    private Worker worker;
    private Sequence dna1;
    private Sequence dna2;
    private boolean status;
    private float calculatedDistance;
    private String comment;

    /**
     * Konstruktor für die Klasse Report.
     * 
     * @param identNumber Die Identifikationsnummer des Berichts.
     * @param worker Der zuständige Mitarbeiter.
     * @param dna1 Die erste DNA Sequenz.
     * @param dna2 Die zweite DNA Sequenz.
     * @param status Der Status des Berichts.
     * @param calculatedDistance Die berechnete evolutionäre Distanz.
     * @param comment Ein Kommentar zum Bericht.
     */
    public Report(int identNumber, Worker worker, Sequence dna1, Sequence dna2, boolean status, float calculatedDistance, String comment) {
        this.identNumber = identNumber;
        this.worker = worker;
        this.dna1 = dna1;
        this.dna2 = dna2;
        this.status = status;
        this.calculatedDistance = calculatedDistance;
        this.comment = comment;
    }

    // Getter methods
    public int getIdentNumber() {
        return identNumber;
    }

    public Worker getWorker() {
        return worker;
    }

    public Sequence getDna1() {
        return dna1;
    }

    public Sequence getDna2() {
        return dna2;
    }

    public boolean isStatus() {
        return status;
    }

    public float getCalculatedDistance() {
        return calculatedDistance;
    }

    public String getComment() {
        return comment;
    }

    // Setter methods
    public void setDescription(Sequence dna1, Sequence dna2) {
        this.dna1 = dna1;
        this.dna2 = dna2;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCalculatedDistance(float distance) {
        this.calculatedDistance = distance;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

