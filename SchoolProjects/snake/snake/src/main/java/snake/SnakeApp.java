package snake;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.github.javaparser.symbolsolver.JavaSymbolSolver;

/**
 * Die Hauptklasse der Snake-Anwendung, die das Spiel initialisiert und anzeigt.
 * Diese Klasse setzt das Spiel auf, indem sie ein Fenster erstellt, das Spielfeld
 * hinzufügt und ein Anwendungssymbol (Icon) festlegt. Sie implementiert das Runnable-Interface,
 * um eine bessere Integration mit der EventQueue für die GUI zu ermöglichen.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class SnakeApp implements Runnable{

	/**
     * Der Einstiegspunkt der Anwendung.
     *
     * @param args Die Befehlszeilenargumente, die der Anwendung übergeben wurden (nicht verwendet).
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new SnakeApp());
	}

	/**
     * Wird aufgerufen, wenn die Anwendung gestartet wird.
     * <p>
     * Initialisiert das Hauptfenster der Anwendung, setzt Titel, Größe, Schließoperation 
     * und das Spielfeld. Ausserdem wird das Fenster zentriert und sichtbar gemacht.
     * </p>
     */
	@Override
	public void run() {
		// TODO Start Teilaufgabe 2
		
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Snake Game");
		
		frame.setIconImage(createIcon());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameBoard(600, 600, 25));
		
		/*pack() berechnet die Größe des Fensters basierend auf den Komponenten, die hinzugefügt wurden. In unserem Fall ist dies die Grösse des Spielfelds.*/
		frame.pack();
		/* Zentriert das Fenster auf dem Bildschirm.*/
		frame.setLocationRelativeTo(null);
		/* Macht das Fenster sichtbar.*/
		frame.setVisible(true);
		
		// TODO End Teilaufgabe 2
	}
	
	/**
     * Erstellt ein Symbolbild für die Anwendung, welches im Titelbalken des Fensters angezeigt.
     *
     * @return Ein Image-Objekt, das das Anwendungssymbol darstellt.
     */
	private Image createIcon() {
       
		BufferedImage icon;
		
		int width = 16;
		int height = 16;
		int imageType = BufferedImage.TYPE_INT_RGB;
		
		icon = new BufferedImage(width, height, imageType);
		Graphics g = icon.getGraphics();
				
        // TODO Start Teilaufgabe 3
        	
        Color black = new Color(0,0,0);
        g.setColor(black);
        g.fillRect(0, 0, width, height);
        
		Color green = new Color(0,128,0);
		g.setColor(green);
		g.fillRect(2, 2, 3, 10);  
	
		Color red = new Color(255,0,0);
		g.setColor(red);
		g.fillRect(10, 10, 3, 3);  
	
		 // Freigeben der Ressourcen
		 g.dispose();
        
        
        // TODO End Teilaufgabe 3
		 
        return icon;
    }
}