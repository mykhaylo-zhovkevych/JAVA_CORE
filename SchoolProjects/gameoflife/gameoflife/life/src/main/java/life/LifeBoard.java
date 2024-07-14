package life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Das {@code LifeBoard} ist eine spezialisierte {@link JPanel}-Komponente,
 * die das Spielfeld für Conways Spiel des Lebens darstellt. Es verwaltet ein
 * Gitter von Zellen, zeichnet sie auf sich selbst und aktualisiert ihren Zustand
 * in regelmäßigen Abständen basierend auf den Spielregeln.
 * 
 * @author Aleksandar Travanov
 * @version 1.0
 */
public class LifeBoard extends JPanel implements ActionListener {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
    private static final Color COLOR_DEAD = Color.gray;
    private static final Color COLOR_ALIVE = Color.red;

    private int width;
    private int height;
    private int xMax;
    private int yMax;
    private Timer timer;
    private Cell[][] cellGrid;

    /**
     * Erstellt ein neues {@code LifeBoard} mit einer spezifischen Breite und Höhe.
     * Initialisiert ein Zellengitter und setzt zufällige Anfangszustände für jede Zelle.
     * 
     * @param width Die Breite des Spielfeldes in Pixeln.
     * @param height Die Höhe des Spielfeldes in Pixeln.
     */
    public LifeBoard(int width, int height) {
        this.width = width;
        this.height = height;
        xMax = width / WIDTH;
        yMax = height / HEIGHT;

        setPreferredSize(new Dimension(width, height));
        setBackground(COLOR_DEAD);
        
        
        
        /*
         * Ein zweidimensionales Array vom Typ Cell, das die Zellmatrix speichert. 
         * Jede Zelle im Gitter kann entweder lebendig oder tot sein.
         * 
         * */
        cellGrid = new Cell[xMax][yMax];
        Random random = new Random();

        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                Cell cell = CellFactory.createCell(x, y);
                if(random.nextBoolean()) {
                    cell.beBorn();
                } else {
                    cell.die();
                }
                cellGrid[x][y] = cell;
            }
        }

        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                cellGrid[x][y].setupNeighbours(cellGrid);
            }
        }

        timer = new Timer(50, this);
        timer.start();
    }

    /**
     * Wird bei jedem Timer-Event aufgerufen, um den Lebenszyklus der Zellen zu verwalten
     * und das Spielfeld neu zu zeichnen.
     * 
     * @param e Das {@link ActionEvent}, das vom Timer ausgelöst wurde.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                cellGrid[i][j].calculateNextState();
            }
        }
        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                cellGrid[i][j].changeState();
            }
        }
        repaint();
    }

    /**
     * Zeichnet das Gitter von Zellen auf das Panel. Jede Zelle wird als Quadrat
     * gezeichnet, dessen Farbe davon abhängt, ob die Zelle lebendig oder tot ist.
     * 
     * @param g2 Das {@link Graphics2D}-Objekt, das für das Zeichnen verwendet wird.
     */
    private void draw(Graphics2D g2) {
        Color oldColor = g2.getColor();
        for(int i = 0; i < xMax; i++) {
            for(int j = 0; j < yMax; j++) {
                if (cellGrid[i][j].isAlive()) {
                    g2.setColor(COLOR_ALIVE);
                } else {
                    g2.setColor(COLOR_DEAD);
                }
                g2.fillRect(cellGrid[i][j].getX() * WIDTH, 
                            cellGrid[i][j].getY() * HEIGHT, WIDTH, HEIGHT);
            }
        }
        g2.setColor(oldColor);
    }
    
    private static final long serialVersionUID = 4800242511174486443L;
}