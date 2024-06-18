package oop;

import java.util.Arrays;

public class DancerApp {
    public static void main(String[] args) {
        	
     
    	/**
    	 * Meine Beobachtungen:
    	 * 
    	 * Es funktioniert nicht, weil es eine Schnittstellen-Implementierung für die arrays.sort(dancers), ohne Realisierung, weiss der Code nicht, wie es zu sortieren.
    	 * 
    	 * Ich muss eine Sortiermethode für die Objekte der DancerApp erstellen
    	 * Allerdings kenne ich die Methode dafür nicht
    	 * Eine Möglichkeit wäre es, eine Schnittstelle zu verwenden, um das Sortieren der Objekte zu ermöglichen
    	 * Mit der Schnittstelle Comparable kann dies erreicht werden
    	 * Wie kann ich das umsetzen?
    	 * Ich überschreibe die Methode compareTo in der Klasse Dancer, um die Dancer-Objekte zu vergleichen
    	 */

        // Array von Dancer-Objekten erstellen
        Dancer[] dancers = {
            new Dancer("Dancer0", 0),
            new Dancer("Dancer3", 3),
            new Dancer("Dancer1", 1),
            new Dancer("Dancer8", 8),
            new Dancer("Dancer7", 7),
            new Dancer("Dancer2", 2),
            new Dancer("Dancer5", 5),
            new Dancer("Dancer4", 4),
            new Dancer("Dancer6", 6),
            new Dancer("Dancer9", 9)
        };

        // Array von Dancer-Objekten sortieren
        Arrays.sort(dancers);

        // Sortierte Dancer-Objekte auf der Konsole ausgeben
        for (Dancer dancer : dancers) {
            System.out.println(dancer + " ");
        }
    }
}
