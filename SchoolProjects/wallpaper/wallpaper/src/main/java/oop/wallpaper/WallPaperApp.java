package oop.wallpaper;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Eine Klasse, die eine Anwendung zur Darstellung von Tapetenmuster startet.
 * 
 * @author Aleksandar Travanov
 * @version 1.0
 */
public class WallPaperApp implements Runnable {
	/**
     * Der Einstiegspunkt der Anwendung.
     *
     * @param args Die Befehlszeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        // Erzeugt einen EventQueue-Thread und übergibt ihm eine Instanz von WallPaperApp.
        EventQueue.invokeLater(new WallPaperApp());
    }

    /**
     * Die Methode, die beim Starten des Threads ausgeführt wird.
     */
    public void run() {
        // Erzeugt ein WallPaperFrame-Objekt mit Ordnung 5 und Bildgröße 512x512.
        WallPaperFrame frame = new WallPaperFrame(512, 57.0);
        // Setzt den Titel des Frames.
        frame.setTitle("Wallpaper Patterns");
        // Legt das Schließen des Frames fest, wenn das Fenster geschlossen wird.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Macht den Frame sichtbar.
        frame.setVisible(true);
    }
}
