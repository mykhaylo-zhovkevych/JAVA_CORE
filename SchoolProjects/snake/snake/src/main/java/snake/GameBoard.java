package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Diese Klasse stellt das Spielfeld für das Snake-Spiel dar. Es handelt sich um ein JPanel,
 * auf dem die Schlange, das Futter und das Gitternetz gezeichnet werden. Zusätzlich wird der
 * Spielstand angezeigt. Die Klasse verarbeitet auch Spielaktionen wie das Bewegen der Schlange
 * und prüft auf Spielende durch Kollision mit dem Spielfeldrand oder dem Schlangenkörper.
 *
 * <p>Das Spielfeld wird initialisiert mit einer festgelegten Breite und Höhe sowie einer
 * Gittergröße, welche die Größe jedes Quadrats im Gitter bestimmt. Ein Timer steuert die
 * regelmäßige Bewegung der Schlange.</p>
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
@SuppressWarnings("serial")
//TODO Teilaufgabe 7: Realisiere ActionListener Interface
public class GameBoard extends JPanel implements ActionListener{ 
	private static Random rnd = new Random();
	// TODO  Teilaufgabe 7 Start: Instanz-Attribute hinzufügen
	int boardWidth;
	int boardHeight;
	int gridSize;
	boolean gameOver;

	Coordinate food;
	Snake snake;
	Timer timer;
	// TODO Teilaufgabe 7 End Instanz-Attribute hinzufügen
	
	/**
     * Konstruktor zur Initialisierung des Spielfelds mit Breite, Höhe und Gittergröße.
     * Initialisiert das Futter, die Schlange und startet den Timer für das Spiel.
     *
     * @param width Die Breite des Spielfelds in Pixeln.
     * @param height Die Höhe des Spielfelds in Pixeln.
     * @param gridSize Die Größe eines Gitterquadrats in Pixeln.
     */
	public GameBoard(int width, int height, int gridSize) {
		boardWidth = width;
		boardHeight = height;
		this.gridSize = gridSize;
		gameOver = false;

		initSnakeAddAsKeyListener();
		initFood();
		setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
	    setBackground(Color.black);
		initAndStartTimer();
	
	}

	/**
     * Initialisiert das Futter an einer zufälligen Position auf dem Spielfeld.
     * Die Methode ruft {@link #placeFood()} auf, um eine neue Koordinate für das
     * Futter zu generieren und speichert diese Koordinate im Attribut {@code food}.
     */
	private void initFood() {
		
		// TODO  Teilaufgabe 7 Start: initFood
		
		food = placeFood();
		
		// TODO  Teilaufgabe 7 End: init Food
	}
	
	/**
     * Generiert eine zufällige Position für das Futter auf dem Spielfeld.
     * Die Position wird so gewählt, dass sie innerhalb der Grenzen des Spielfelds liegt
     * und auf dem Gitternetz basiert, indem sie durch die {@code gridSize} teilbar ist.
     * 
     * @return Eine neue {@link Coordinate} für die Position des Futters.
     */
	private Coordinate placeFood() {
		// TODO  Teilaufgabe 7 Start: placeFood
		 
		int x, y;
	    do {
	        x = rnd.nextInt(boardWidth / gridSize) * gridSize;
	        y = rnd.nextInt(boardHeight / gridSize) * gridSize;
	    } while (checkFoodOnSnake(x, y));
	    return new Coordinate(x, y);
	}
	private boolean checkFoodOnSnake(int x, int y) {
	    for (Coordinate segment : snake.getBody()) {
	        if (segment.getX() == x && segment.getY() == y) {
	            return true;  
	        }
	    }
	    return false;  
		
		// TODO  Teilaufgabe 7 Start: placeFood
	}

	/**
     * Initialisiert die Schlange und fügt diese als KeyListener hinzu,
     * damit Tastatureingaben zur Steuerung der Schlange verwendet werden können.
     * Setzt das {@link GameBoard} auch als fokussierbar, 
     * um Tastatureingaben empfangen zu können.
     */
	private void initSnakeAddAsKeyListener() {
		// TODO  Teilaufgabe 7 Start initSnakeAddAsKeyListener
		
		snake = new Snake(new Coordinate(boardWidth / 2, boardHeight / 2), 1, 0, gridSize);
	    addKeyListener(snake);
	    setFocusable(true);
	    requestFocusInWindow();  
	    
		// TODO  Teilaufgabe 7 Start initSnakeAddAsKeyListene
	}
	
	/**
     * Initialisiert und startet den Timer, der für die regelmäßige Aktualisierung und
     * Bewegung der Schlange verwendet wird. Der Timer löst den {@link ActionListener}
     * aus, das in dieser Klasse implementiert ist, um die Spiellogik bei jedem Tick auszuführen.
     */
	private void initAndStartTimer() {
		// TODO  Teilaufgabe 7 Start: initAndStartTimer
		
		timer = new Timer(150, this);  // Setzt den Timer, um alle 150 ms ein ActionEvent zu steuern
	    timer.start();
	    
		// TODO  Teilaufgabe 7 End: init Timer
	}
	
	/**
     * Überschreibt die {@code paintComponent}-Methode von {@link JPanel} zur
     * Darstellung des Spielfelds, einschließlich des Gitters, der Schlange und des Futters.
     * Zusätzlich wird der aktuelle Spielstand (die Größe der Schlange) 
     * in der oberen linken Ecke angezeigt.
     * Diese Methode wird automatisch aufgerufen, wann immer das JPanel neu gezeichnet werden muss,
     * beispielsweise nach dem Aufrufen von {@code repaint()} 
     * im {@code actionPerformed}-Methodenrumpf.
     * <p>
     * Die Methode ruft spezialisierte Zeichenmethoden auf, um die einzelnen Komponenten zu zeichnen:
     * <ul>
     * <li>{@link #drawGrid(Graphics)} zum Zeichnen des Gitters.</li>
     * <li>{@link #drawSnakeAndFood(Graphics)} zum Zeichnen von Schlange und Futter.</li>
     * <li>{@link #writeScore(Graphics)} zum Anzeigen der Punktzahl.</li>
     * </ul>
     * </p>
     * <p>
     *
     * @param g Das {@link Graphics}-Objekt, das für das Zeichnen auf diesem Panel verwendet wird.
     */
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		drawGrid(g);
		drawSnakeAndFood(g);
		writeScore(g);
	}

	/**
     * Zeichnet ein Gitternetz auf dem Spielfeld,Jedes Quadrat des Gitters entspricht einer
     * möglichen Position der Schlange oder des Futters. 
     * 
     * <p>
     * Diese Methode zeichnet die Gitter-Linien, die basierend auf der Breite, Höhe und der
     * Größe jedes Gitterquadrats (gridSize) gezogen werden müssen. Sie verwendet ein 
     * {@link Graphics}-Objekt, um Linien in einer spezifizierten Farbe zu zeichnen, 
     * wobei für die horizontale und vertikale Orientierung jeweils Schleifen durchlaufen werden.
     * </p>
     * 
     * @param g Das {@link Graphics}-Objekt, das zum Zeichnen des Gitters verwendet wird. 
     * 
     */
	private void drawGrid(Graphics g) {
		// TODO Start Teilaufgabe 4
		int width = 800;
		int height = 800;
		int gridSize = 25;
		
		Color darkGray = g.getColor();
		g.setColor(darkGray);
		
		for (int x = 0; x <= boardWidth; x += gridSize) {
			g.drawLine(x, 0, x, height);
		}
		
		for (int y = 0; y <= boardHeight; y += gridSize) {
			g.drawLine(0, y, width, y);
		}
		
		// TODO End Teilaufgabe 4
	}
	
	/**
     * Zeichnet die Schlange und das Futter auf dem Spielfeld. Diese Methode ist verantwortlich
     * für die visuelle Darstellung der Schlange, einschließlich ihres Kopfes und Körpers, sowie
     * des Futters an seiner aktuellen Position.
     * 
     * <p>
     * Die Methode verwendet Iterationen, um durch die Körpersegmente der Schlange zu gehen und
     * jedes Segment als gefülltes Quadrat zu zeichnen. Die Größe jedes Quadrats entspricht der
     * {@code gridSize}, die auch für das Zeichnen des Futters verwendet wird.
     * </p>
     * 
     * @param g Das {@link Graphics}-Objekt, das zum Zeichnen von Schlange und Futter auf dem
     *          Spielfeld verwendet wird.
     */
	private void drawSnakeAndFood(Graphics g) {
		// TODO  Teilaufgabe 7 Start: drawSnakeAndFood
		
		if (snake != null) {
			Color green = new Color(0,128,0);
			drawSquare(g, snake.getHead(), green);
			
	        for (Coordinate restOfBody : snake.getBody()) {
	            drawSquare(g, restOfBody, Color.GREEN);
	        }
		}
		
	    drawSquare(g, food, Color.red);
		
		// TODO  Teilaufgabe 7 End: drawSnakeAndFood
	}
	
	/**
     * Zeichnet ein einzelnes Quadrat auf dem Spielfeld an der Position, die durch ein
     * {@link Coordinate}-Objekt spezifiziert ist. Diese Methode wird genutzt, um die Segmente
     * des Schlangenkörpers sowie das Futter zu zeichnen.
     * 
     * @param g Das {@link Graphics}-Objekt, das zum Zeichnen des Quadrats verwendet wird. 
     * @param s Die {@link Coordinate} des zu zeichnenden Quadrats. 
	 * @param red 
     */
	private void drawSquare(Graphics g, Coordinate s, Color red) {
		
		g.setColor(red);
		g.fillRect(s.getX(), s.getY(), gridSize, gridSize);
	}
	
	/**
     * Zeigt den aktuellen Spielstand an. Der Spielstand basiert auf der Größe der Schlange, 
     * wobei jedes Segment der Schlange einen Punkt zählt.
     * 
     * <p>
     * Die Methode nutzt die {@code getBodySize}-Methode der {@code Snake}-Klasse, um die aktuelle
     * Größe der Schlange zu ermitteln und somit den Spielstand zu berechnen. Der Spielstand wird
     * als einfacher Text dargestellt.
     * </p>
     * 
     * @param g Das {@link Graphics}-Objekt, das zum Zeichnen des Textes verwendet wird.
     */
	private void writeScore(Graphics g) {
		// TODO  Teilaufgabe 7 Start writeScore
		
		 g.setColor(Color.WHITE);
		 g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		    if (gameOver) {
		        g.setFont(new Font("TimesRoman", Font.BOLD, 45));
		        FontMetrics metrics = g.getFontMetrics();
		        String gameOverText = "GAME OVER";
		        g.drawString(gameOverText, (boardWidth - metrics.stringWidth(gameOverText)) / 2, boardHeight / 2);
		    } else {
		        // Display the current score
		        String scoreText = "Score: " + snake.getBodySize();
		        g.drawString(scoreText, 20, 30); 
		    }
		    
		// TODO  Teilaufgabe 7 End writeScore
	}

	/**
     * Reagiert auf Timer-Ereignisse, um die Spiellogik für jede "Tick" des Timers auszuführen.
     * Diese Methode wird automatisch aufgerufen, wenn der Timer, der das Spiel steuert, abläuft.
     * Innerhalb dieser Methode erfolgt die Bewegung der Schlange basierend auf der aktuellen
     * Richtung der Geschwindigkeit. Es wird auch geprüft, 
     * ob die Schlange das Futter gefressen hat,
     * und ob Kollisionen mit dem Schlangenkörper oder den Wänden des Spielfelds stattgefunden haben.
     * 
     * <p>
     * Bei einer Kollision oder wenn die Schlange die Grenzen des Spielfelds überschreitet, 
     * wird das Spiel beendet, indem der Timer angehalten wird. 
     * Wenn die Schlange das Futter frisst, wird der Spielstand erhöht und neues Futter 
     * an einer zufälligen Position platziert.
     * </p>
     * 
     * <p>
     * Nach der Ausführung der Spiellogik wird das Spielfeld neu gezeichnet.
     * </p>
     * 
     * @param e Das ActionEvent, das die Methode auslöst. In diesem Kontext ist es immer das
     *          Ereignis, das durch das Ablaufen des Timers generiert wird.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO  Teilaufgabe 7 Start actionPerformed
		
		 if (!gameOver) {
		        snake.move();
		        
		        // Überprüfen, ob die Schlange das Essen isst
		        if (snake.eat(food)) {
		            // absofort regeneriert neue Punkt Schlag es nicht Schlange überlappt
		            do {
		                food = placeFood();
		              // sicherstellt dass food nicht über Kopf plaziert ist
		            } while (snake.getHead().equals(food) || checkFoodOnSnake(food.x, food.y));
		        }
		        
		        if (snake.bodyCollision()) {
		            gameOver = true;
		            timer.stop();  
		        }
		       
		        if (checkWallCollision()) {
		            gameOver = true;
		            timer.stop(); 
		        }
		        repaint();  
		    }
		}

		private boolean checkWallCollision() {
		    Coordinate head = snake.getHead();
		    return head.getX() < 0 || head.getX() >= boardWidth || head.getY() < 0 || head.getY() >= boardHeight;
		}
}
