package dna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Klasse, die ein Labor darstellt, in dem der DNA Distanz berechnet wird und in dem ein neun Mitarbeiter zum Laboratory hinzugefügt werden kann.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Laboratory {
    private String laborAddress;
    private List<Worker> workers;

    /**
     * Konstruktor für das Laboratory.
     * 
     * @param laborAddress Die Adresse des Labors.
     */
    public Laboratory(String laborAddress) {
        this.laborAddress = laborAddress;
        this.workers = new ArrayList<>();
    }
    /**
     * Fügt einen Mitarbeiter dem Labor hinzu.
     * 
     * @param worker der hinzuzufügende Mitarbeiter.
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }
    
    /**
     * Sucht einen Mitarbeiter anhand Vor und Nachname.
     * 
     * @param firstName der Vorname des Mitarbeiters.
     * @param lastName der Nachname des Mitarbeiters.
     * @return Der gefundene Mitarbeiter oder null, wenn kein Mitarbeiter gefunden wurde.
     */
    public Worker getWorkerByName(String firstName, String lastName) {
        for (int i = 0; i < workers.size(); i++) {
            Worker worker = workers.get(i);
            if (worker.getFirstName().equals(firstName) 
            		&& 
            		worker.getLastName().equals(lastName)) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Gibt die Liste der Mitarbeiter im Labor zurück.
     * 
     * @return Die Liste der Mitarbeiter.
     */
    public List<Worker> getWorkers() {
        return workers;
    }

    /**
     * Berechnet die evolutionäre Distanz zwischen zwei DNA Sequenzen.
     * 
     * @param dna1 Die erste DNA Sequenz.
     * @param dna2 Die zweite DNA Sequenz.
     * @return Die berechnete evolutionäre Distanz.
     */
    public float calculateEvolutionaryDistance(String dna1, String dna2) {
    /* Beschreibung der levenshtein Distanz Algorithmus.
     * Ist eine messbare Weisse von berechneten Unterschieden zwischen zwei Strings oder DNA
     * Es gibt 4 Arten der Bearbeitung Einfügung Löschung Subsitution oder Nichts
     * */	
    // Wenn beide String leer sind, dann ist es 0, wenn zwei String leer sind, dann ist die Distanz die Länge der anderen String
    	if (dna1.isEmpty()) {
            return dna2.length();
        }

        if (dna2.isEmpty()) {
            return dna1.length();
        }
    // jeder wird separat berechnet und kann 0 oder 1 für jeden Char der String sein
        int substitution = (int)calculateEvolutionaryDistance(dna1.substring(1), dna2.substring(1)) 
            + (dna1.charAt(0) == dna2.charAt(0) ? 0 : 1);
        
        int insertion = (int)calculateEvolutionaryDistance(dna1, dna2.substring(1)) + 1;
        
        int deletion = (int)calculateEvolutionaryDistance(dna1.substring(1), dna2) + 1;
        
    // Das Programm berechnet alle möglichen Wege (Substitution, Einfügen, Löschen) und wählt den Weg mit den minimalen Kosten.
    // Dieser orElse(Integer.MAX_VALUE) ist eine Sicherheitsmassnahme, weil fals stream ist leer max int wird von java zurückgegeben
        return Arrays.stream(new int[] {substitution, insertion, deletion}).min().orElse(Integer.MAX_VALUE);
    }
    
}
