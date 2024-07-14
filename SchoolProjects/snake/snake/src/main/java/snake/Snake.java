package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse Snake implementiert das Verhalten einer Schlange im Spiel,
 * einschließlich Bewegung, Wachstum beim Essen und Kollisionserkennung.
 * Sie implementiert auch das KeyListener-Interface, um Tastatureingaben
 * für die Steuerung der Schlange zu verarbeiten.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class Snake implements KeyListener {
	/**
     * Der Kopf der Schlange. Wird für Bewegung und Kollisionsdetektion verwendet.
     */
	Coordinate head;
	
	/**
     * Eine Liste, die den Körper der Schlange darstellt. Jedes Element der Liste
     * ist eine Koordinate, die ein Segment des Schlangenkörpers repräsentiert.
     */
	List<Coordinate> body;
	
	 /**
     * Die Geschwindigkeit der Schlange in der X-Achse. Bestimmt in welche Richtung sich
     * die Schlange horizontal bewegt. Folgende Werte sind möglich: -1, 0, 1
     */
	int velocityX;
	
	/**
     * Die Geschwindigkeit der Schlange in der Y-Achse. Bestimmt in welche Richtung wie sich
     * die Schlange vertikal bewegt. Folgende Werte sind möglich: -1, 0, 1
     * 
     */
	int velocityY;

	/**
     * Konstruktor, um eine neue Schlange mit einem gegebenen Kopf und Geschwindigkeiten
     * zu initialisieren.
     * 
     * @param head Der Kopf der Schlange bei der Initialisierung.
     * @param velocityX Die initiale Geschwindigkeit der Schlange in der X-Achse.
     * @param velocityY Die initiale Geschwindigkeit der Schlange in der Y-Achse.
	 * @param gridSize 
     */
	public Snake(Coordinate head, int velocityX, int velocityY, int gridSize) {
		// TODO Start Konstruktor
		
		this.head = head;
	    this.velocityX = velocityX;
	    this.velocityY = velocityY;
	    this.body = new ArrayList<>(); 
	    
	    int initialLength = 3;
	    for (int i = 1; i < initialLength; i++) {
	        body.add(new Coordinate(head.x , head.y));
	    }
		
		// TODO End Konstruktor
	}
	
	/**
     * Bewegt die Schlange basierend auf ihrer aktuellen Richtung Geschwindigkeit.
     * Aktualisiert die Position des Kopfes und folgt mit dem Körper.
     */
	public void move() {
		/*
		 * Die Idee besteht darin, dass jedes Körperteil der Schlange die Position des vorherigen Segments in jedem Spielzug übernimmt
		 * */
	    int oldHeadX = head.x;
	    int oldHeadY = head.y;

	    head.x += velocityX * 25;  
	    head.y += velocityY * 25;  

	    if (!body.isEmpty()) {
	        for (int i = body.size() - 1; i > 0; i--) {
	            body.get(i).x = body.get(i - 1).x;
	            body.get(i).y = body.get(i - 1).y;
	        }
	        body.get(0).x = oldHeadX;
	        body.get(0).y = oldHeadY;
	    }
	}
	
	/**
     * Prüft, ob der Kopf der Schlange die angegebene Nahrung erreicht hat.
     * Wenn ja, wächst die Schlange um ein Segment.
     * 
     * @param food Die Koordinate des Essens.
     * @return true, wenn die Schlange das Essen gegessen hat, sonst false.
     */
	public boolean eat(Coordinate food) {
	    if (head.x == food.x && head.y == food.y) {
	    	
	        Coordinate newBodyPart;
	        if (body.isEmpty()) {
	        	// nicht funktioniert nur else 
	        	// addiert hinten der head basiert auf velocityX und velocityY
	        	newBodyPart = new Coordinate(head.x - velocityX * 25, head.y - velocityY * 25);
	        } else {
	            // addiert hinten der letzte Part der Snake
	            Coordinate lastPart = body.get(body.size() - 1);
	            newBodyPart = new Coordinate(lastPart.x - velocityX * 25, lastPart.y - velocityY * 25);
	        }
	        body.add(newBodyPart);
	        return true;
	    }
	    return false;
	}
	
	/**
     * Prüft, ob der Kopf der Schlange mit irgendeinem Teil ihres Körpers kollidiert ist.
     * 
     * @return true, wenn eine Kollision aufgetreten ist, sonst false.
     */
	public boolean bodyCollision() {
		boolean gameOver = false;
		// TODO Start bodyCollision
		
		// da es startet zu vergleichen von 1 und nicht 0
		  for (int i = 1; i < body.size() ; i++) {
			  if (head.x == body.get(i).x && head.y == body.get(i).y) {
		            return true;  
		        }
		  }
		// TODO End bodyCollision
        return gameOver;
	}

	/**
     * Gibt die Größe des Körpers der Schlange zurück.
     * 
     * @return Die Anzahl der Segmente im Körper der Schlange.
     */
	public int getBodySize() {
		return body.size();
	}
	
	/**
     * Gibt den Kopf der Schlange zurück.
     * 
     * @return Eine Instanz von {@link Coordinate}, die die Position des Kopfes der Schlange 
     * repräsentiert.
     */
	public Coordinate getHead() {
		return head;
	}
	
	/**
     * Gibt die X-Position des Kopfes der Schlange zurück.
     * 
     * @return Die X-Koordinate des Kopfes der Schlange.
     */
	public int getHeadX() {
		return head.x;
	}
	
	/**
     * Gibt die Y-Position des Kopfes der Schlange zurück.
     * 
     * @return Die Y-Koordinate des Kopfes der Schlange.
     */
	public int getHeadY() {
		return head.y;
	}
	
	/**
     * Gibt einen Iterator zurück, der es ermöglicht, über den Körper der Schlange zu iterieren.
     * Jedes Element der Iteration repräsentiert ein Segment des Schlangenkörpers als {@link Coordinate}.
     * <p>
     * Dies kann nützlich sein, um z.B. alle Segmente des Schlangenkörpers in einem GUI-Element zu zeichnen.
     * </p>
     * 
     * <b>Beispielanwendung:</b>
     * <pre>
     * {@code
     * Iterator<Coordinate> iterator = snake.bodyIterator();
     * while(iterator.hasNext()) {
     *     Coordinate segment = iterator.next();
     *     // Zeichne jedes Segment an der Position (segment.getX(), segment.getY())
     * }
     * }
     * </pre>
     * 
     * @return Ein Iterator für die Liste der Körpersegmente der Schlange.
     */
	public Iterator<Coordinate> bodyIterator() {
		return body.iterator();
	}
	
	/**
     * Wird aufgerufen, wenn eine Taste gedrückt wird. Diese Methode steuert die Richtung der Schlange
     * basierend auf den Pfeiltasteneingaben. Die Schlange kann in jede der vier Hauptkardinalrichtungen
     * (oben, unten, links, rechts) gesteuert werden, aber sie kann nicht in die entgegengesetzte Richtung
     * ihrer aktuellen Bewegung umkehren.
     * <p>
     * <b>Beispiel:</b> Wenn die Schlange sich nach rechts bewegt (velocityX = 1), kann sie nicht unmittelbar
     * nach links gesteuert werden, um eine Kollision mit sich selbst zu verhindern.
     * </p>
     * 
     * <p>
     * Die Methode ändert die Geschwindigkeitsvariablen der Schlange entsprechend:
     * <ul>
     * <li>VK_UP: Bewegung nach oben (velocityX = 0, velocityY = -1), sofern sie nicht bereits nach unten bewegt wird.</li>
     * <li>VK_DOWN: Bewegung nach unten (velocityX = 0, velocityY = 1), sofern sie nicht bereits nach oben bewegt wird.</li>
     * <li>VK_LEFT: Bewegung nach links (velocityX = -1, velocityY = 0), sofern sie nicht bereits nach rechts bewegt wird.</li>
     * <li>VK_RIGHT: Bewegung nach rechts (velocityX = 1, velocityY = 0), sofern sie nicht bereits nach links bewegt wird.</li>
     * </ul>
     * </p>
     * 
     * @param e Das KeyEvent, das die Methode auslöst. Enthält Informationen über die gedrückte Taste.
     */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            if (velocityY == 0) {
                velocityX = 0;
                velocityY = -1;
            }
            break;
        case KeyEvent.VK_DOWN:
            if (velocityY == 0) {
                velocityX = 0;
                velocityY = 1;
            }
            break;
        case KeyEvent.VK_LEFT:
            if (velocityX == 0) {
                velocityX = -1;
                velocityY = 0;
            }
            break;
        case KeyEvent.VK_RIGHT:
            if (velocityX == 0) {
                velocityX = 1;
                velocityY = 0;
            }
            break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// do nothing
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// do nothing
	}
	
	/**
	 * Gibt die Liste der Koordinaten zurück, die den Körper der Schlange darstellen.
	 * Jede Koordinate in der Liste repräsentiert ein Teil des Schlangenkörpers.
	 * 
	 * @return Eine Liste von {@link Coordinate}Objekten, die den Körper der Schlange darstellen.
	 */
	public List<Coordinate> getBody() {
        return body; 
    }
}
