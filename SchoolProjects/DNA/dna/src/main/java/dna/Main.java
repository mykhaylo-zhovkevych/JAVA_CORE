package dna;

import java.util.List;
import java.util.Scanner;

/**
 * Hauptklasse des DNA Distanzberechnungsprogramms.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Laboratory lab = new Laboratory("Zürcherstrasse 23, 8000 Zürich");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("Willkommen zur DNA Distanzsberechnung Programm."); 
        System.out.println("Zum Programm nutezn müssen Sie zunächst Mitarbeiter anlegen und dann können die Distanz zwischen DNA berechnen.");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        
        while (true) {
            System.out.println("Wählen Sie eine Option:");
            System.out.println("1. Mitarbeiter hinzufügen");
            System.out.println("2. Informationen über Mitarbeiter anzeigen");
            System.out.println("3. DNA-Test mit 2 Proben durchführen");
            System.out.println("4. Berichte anzeigen");
            System.out.println("5. Berichten drucken für Aktenschrank");
            System.out.println("6. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addWorker(lab, scanner);
                    break;
                case 2:
                	showWorkerInfo(lab);
                    break;
                case 3:
                    performDNATest(lab, library, scanner);
                    break;
                case 4:
                    showReports(library);
                    break;
                case 5:
                	printReport(library);
                    break;
                case 6:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }
    
    
    /**
     * Fügt einen Mitarbeiter hinzu.
     * 
     * @param lab Das Labor, zu dem der Mitarbeiter hinzugefügt wird.
     * @param scanner Der Scanner zum Lesen der Benutzereingaben.
     */
    private static void addWorker(Laboratory lab, Scanner scanner) {
        System.out.println("Geben Sie den Vornamen des Mitarbeiters ein:");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("Fehler: Der Vorname darf nicht leer sein.");
            return;
        }

        System.out.println("Geben Sie den Nachnamen des Mitarbeiters ein:");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Fehler: Der Nachname darf nicht leer sein.");
            return;
        }

        System.out.println("Geben Sie das Geburtsdatum des Mitarbeiters ein (YYYY-MM-DD):");
        String birthDate = scanner.nextLine().trim();
        if (birthDate.isEmpty()) {
            System.out.println("Fehler: Das Geburtsdatum darf nicht leer sein.");
            return;
        }

        Worker worker = new Worker(firstName, lastName, birthDate);
        lab.addWorker(worker);
        System.out.println("Mitarbeiter hinzugefügt.");
    }

    /**
     * Zeigt Informationen über die Mitarbeiter an.
     * 
     * @param lab Das Labor, dessen Mitarbeiterinformationen angezeigt werden.
     */
    private static void showWorkerInfo(Laboratory lab) {
        if (lab.getWorkers().isEmpty()) {
            System.out.println("Keine Mitarbeiter vorhanden.");
        } else {
            List<Worker> workers = lab.getWorkers();
            for (int i = 0; i < workers.size(); i++) {
                Worker worker = workers.get(i);
                System.out.println(worker.getWorkerDetails());
            }
        }
    }

    
    /**
     * Führt einen DNA Test mit zwei Proben durch.
     * 
     * @param lab Das Labor, in dem der Test durchgeführt wird.
     * @param library Die Bibliothek, in der die Berichte gespeichert werden.
     * @param scanner Der Scanner zum Lesen der Benutzereingaben.
     */
    private static void performDNATest(Laboratory lab, Library library, Scanner scanner) {
        System.out.println("Geben Sie die erste DNA Sequenz ein:");
        String sequenceDNA1 = scanner.nextLine();
        System.out.println("Geben Sie die Identifikationsnummer, wie ID1 für der ersten DNA Sequenz ein:");
        String identNummer1 = scanner.nextLine();

        System.out.println("Möchten Sie Fundort und Funddatum der ersten DNA Sequenz eingeben? (ja/nein)");
        String includeLocationAndDate1 = scanner.nextLine();
        String foundPlace1 = "";
        String foundTime1 = "";

        if (includeLocationAndDate1.equalsIgnoreCase("ja")) {
            System.out.println("Geben Sie den Fundort der ersten DNA Sequenz ein:");
            foundPlace1 = scanner.nextLine();
            System.out.println("Geben Sie das Funddatum der ersten DNA Sequenz ein:");
            foundTime1 = scanner.nextLine();
        }

        Sequence dna1 = new Sequence(sequenceDNA1, identNummer1, foundPlace1, foundTime1);
        if (!dna1.validSequence(sequenceDNA1)) {
            System.out.println("Die erste DNA-Sequenz ist ungültig.");
            return;
        }

        System.out.println("Geben Sie die zweite DNA Sequenz ein:");
        String sequenceDNA2 = scanner.nextLine();
        System.out.println("Geben Sie die Identifikationsnummer, wie ID2 für der zweiten DNA Sequenz ein:");
        String identNummer2 = scanner.nextLine();

        System.out.println("Möchten Sie Fundort und Funddatum der zweiten DNA Sequenz eingeben? (ja/nein)");
        String includeLocationAndDate2 = scanner.nextLine();
        String foundPlace2 = "";
        String foundTime2 = "";

        if (includeLocationAndDate2.equalsIgnoreCase("ja")) {
            System.out.println("Geben Sie den Fundort der zweiten DNA Sequenz ein:");
            foundPlace2 = scanner.nextLine();
            System.out.println("Geben Sie das Funddatum der zweiten DNA Sequenz ein:");
            foundTime2 = scanner.nextLine();
        }

        Sequence dna2 = new Sequence(sequenceDNA2, identNummer2, foundPlace2, foundTime2);
        if (!dna2.validSequence(sequenceDNA2)) {
            System.out.println("Die zweite DNA Sequenz ist ungültig.");
            return;
        }

        // Nach die Sequenzen
        System.out.println("Geben Sie die numerische Identifikationsnummer des Berichts ein:");
        int reportId = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Geben Sie den Vornamen des zuständigen Mitarbeiters ein:");
        String responsibleFirstName = scanner.nextLine();
        System.out.println("Geben Sie den Nachnamen des zuständigen Mitarbeiters ein:");
        String responsibleLastName = scanner.nextLine();

        Worker responsibleWorker = lab.getWorkerByName(responsibleFirstName, responsibleLastName);
        if (responsibleWorker == null) {
            System.out.println("Kein Mitarbeiter mit diesem Namen gefunden.");
            return;
        }

        
        float distance = lab.calculateEvolutionaryDistance(sequenceDNA1, sequenceDNA2);
        Report report = new Report(reportId, responsibleWorker, dna1, dna2, true, distance, "Kein Kommentar");
        library.addReport(report);

        System.out.println("\n");
    	System.out.println("------------------------------------------------------");
        System.out.println("Bericht erfolgreich erstellt:");
        System.out.println("Berichts-ID: " + report.getIdentNumber());
        System.out.println("Zuständiger Mitarbeiter: " + responsibleWorker.getWorkerDetails());
        System.out.println("DNA-Sequenz 1: " + report.getDna1().getSequence());
        System.out.println("DNA-Sequenz 2: " + report.getDna2().getSequence());
        System.out.println("Berechnete Distanz: " + report.getCalculatedDistance());
        System.out.println("------------------------------------------------------");
    }

    /**
     * Zeigt die Berichte an.
     * 
     * @param library Die Bibliothek aus der die Berichte abgerufen werden.
     */
    private static void showReports(Library library) {
        if (library.getReports().isEmpty()) {
            System.out.println("Keine Berichte vorhanden.");
        } else {
            List<Report> reports = library.getReports();
            for (int i = 0; i < reports.size(); i++) {
                Report report = reports.get(i);
                System.out.println("\n");
                System.out.println("------------------------------------------------------");
                System.out.println("Berichts-ID: " + report.getIdentNumber());
                System.out.println("Zuständiger Mitarbeiter: " + report.getWorker().getWorkerDetails());
                System.out.println("DNA-Sequenz 1: " + report.getDna1().getSequence());
                System.out.println("DNA-Sequenz 2: " + report.getDna2().getSequence());
                System.out.println("Berechnete Distanz: " + report.getCalculatedDistance());
                System.out.println("Status: " + (report.isStatus() ? "Abgeschlossen" : "Nicht abgeschlossen"));
                System.out.println("Kommentar: " + report.getComment());
                System.out.println("------------------------------------------------------");
            }
        }
    }

    /**
     * Druckt die Berichte.
     * 
     * @param library Die Bibliothek aus der die Berichte gedruckt werden.
     */
    private static void printReport(Library library) {
        System.out.println("Speichern der Berichte in Datei 'reports.txt'...");
        library.printReport("reports.txt");
        System.out.println("Die Datei wurde im Projektverzeichnis gespeichert!");
    }
}


