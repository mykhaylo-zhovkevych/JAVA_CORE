package dna;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, die repräsentiert eine Bibliothek und wo die Berichte gespecihert und gedruckt werden können.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Library {
    private List<Report> reports;

    /**
     * Konstruktor für die Klasse Library.
     */
    public Library() {
        reports = new ArrayList<>();
    }

    /**
     * Fügt einen Bericht zur Bibliothek hinzu.
     * 
     * @param report Der hinzuzufügende Bericht.
     */
    public void addReport(Report report) {
        reports.add(report);
    }


    /**
     * Gibt die Liste der Berichte zurück.
     * 
     * @return Die Liste der Berichte.
     */
    public List<Report> getReports() {
        return reports;
    }
    
    /**
     * Druckt die Berichte in eine Datei.
     * 
     * @param fileName ist der Name der Datei, in die die Berichte gedruckt werden.
     */
    public void printReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            List<Report> reportList = reports;
            for (int i = 0; i < reportList.size(); i++) {
                Report report = reportList.get(i);
                writer.write("------------------------------------------------------\n");
                writer.write("Berichts-ID: " + report.getIdentNumber() + "\n");
                writer.write("Zuständiger Mitarbeiter: " + report.getWorker().getWorkerDetails() + "\n");
                writer.write("DNA-Sequenz 1: " + report.getDna1().getSequence() + "\n");
                writer.write("DNA-Sequenz 2: " + report.getDna2().getSequence() + "\n");
                writer.write("Berechnete Distanz: " + report.getCalculatedDistance() + "\n");
                writer.write("Status: " + (report.isStatus() ? "Abgeschlossen" : "Nicht abgeschlossen") + "\n");
                writer.write("Kommentar: " + report.getComment() + "\n");
                writer.write("------------------------------------------------------\n");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Berichte: " + e.getMessage());
        }
    }

    
}
