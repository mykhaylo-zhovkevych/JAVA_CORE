package life;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse AbstractCell ist eine abstrakte Klasse, die dient als eine Impementierung für Cell Intreface, Da wird 
 * grundlegende Eigenschaften und Methoden zur Verwaltung des Zustands der Zelle und ihrer Nachbarn.
 * 
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */

public abstract class AbstractCell implements Cell {
	// In Pakets zugänglich sind und Unterklassen zugreifen werden können
	/**
     * Zeigt an, ob die Zelle lebendig ist.
     */
    protected boolean isAlive;
    /**
     * Liste der benachbarten Zellen.
     */
    protected List<Cell> neighbours;
    /**
     * Die y und x-Koordinaten der Zellen.
     */
    protected int x, y;
    
    protected boolean nextAlive;  // Diese Variable in AbstractCell hinzufügen

    

	/**
	 * Konstruktor AbstractCell(int x, int y)
	 * 
	 * @param x Die x-Koordinate der Zelle.
	 * @param y Die y-Koordinate der Zelle.
	 */

    // Konstruktor nihmmt die x und y und speichet sie in x und y 
    public AbstractCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.neighbours = new ArrayList<>();
        this.isAlive = false;
    }

    /**
     * Methode setupNeighbours(Cell[][] cellGrid)
     * 
     * Richtet die benachbarten Zellen auf der Grundlage des angegebenen Zellgitters ein.
     *
     * @param cellGrid Das Gitter der Zellen.
     */
 
    @Override
    public void setupNeighbours(Cell[][] cellGrid) {

        int[] richtungen = {-1, 0, 1}; // Richtungs-Arrays für x und y

        for (int i = 0; i < richtungen.length; i++) {
            int dx = richtungen[i];
            for (int j = 0; j < richtungen.length; j++) {
                int dy = richtungen[j];

                if (dx == -1 && dy == -1) {
                    // Links oben (x-1, y-1)
                } else if (dx == -1 && dy == 0) {
                    // Direkt links (x-1, y)
                } else if (dx == -1 && dy == 1) {
                    // Links unten (x-1, y+1)
                } else if (dx == 0 && dy == -1) {
                    // Direkt oben (x, y-1)
                } else if (dx == 0 && dy == 0) {
                    continue; // Die Zelle selbst (x, y), wird übersprungen
                } else if (dx == 0 && dy == 1) {
                    // Direkt unten (x, y+1)
                } else if (dx == 1 && dy == -1) {
                    // Rechts oben (x+1, y-1)
                } else if (dx == 1 && dy == 0) {
                    // Direkt rechts (x+1, y)
                } else if (dx == 1 && dy == 1) {
                    // Rechts unten (x+1, y+1)
                	
                }
                /*
                (0,0) (0,1) (0,2)
				(1,0) (1,1) (1,2)
				(2,0) (2,1) (2,2)
				Links oben: dx = -1, dy = -1 => (1-1, 1-1) = (0, 0)
				Direkt links: dx = -1, dy = 0 => (1-1, 1) = (0, 1)
				Links unten: dx = -1, dy = 1 => (1-1, 1+1) = (0, 2)
				Direkt oben: dx = 0, dy = -1 => (1, 1-1) = (1, 0)
				Die Zelle selbst: dx = 0, dy = 0 => wird übersprungen
				Direkt unten: dx = 0, dy = 1 => (1, 1+1) = (1, 2)
				Rechts oben: dx = 1, dy = -1 => (1+1, 1-1) = (2, 0)
				Direkt rechts: dx = 1, dy = 0 => (1+1, 1) = (2, 1)
				Rechts unten: dx = 1, dy = 1 => (1+1, 1+1) = (2, 2)
                */	
                

                // Berechnung der Nachbar-Koordinaten
                int nx = x + dx;
                int ny = y + dy;

                // Überprüfung, ob die Nachbar-Koordinaten innerhalb der Gittergrenzen liegen
                if (nx >= 0 && nx < cellGrid.length && ny >= 0 && ny < cellGrid[nx].length) {
                    neighbours.add(cellGrid[nx][ny]);
                }
            }
        }
    }

    /**
     * Methode changeState()
     * 
     * Berechnet den nächsten Zustand der Zelle basierend auf ihrem aktuellen 
	 * Zustand und ihren Nachbarn.
     */    
    @Override
    public void changeState() {
    	
    	isAlive = nextAlive;
    }
    /**
     * Methode beBorn()
     * 
     * Macht die Zelle als lebendig.
     */
    @Override
    public void beBorn() {
        isAlive = true;
         
    }
    /**
     * Methode die()
     * 
     * Macht die Zelle als tot.
     */
    @Override
    public void die() {
        isAlive = false;
    }
    /**
     * Methode isAlive()
     * 
     * Macht die Zelle als lebendig.
     */
    @Override
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Methode getX()
     * 
     * Ermittelt die x-Koordinate der Zelle.
     *
     * @return Die x-Koordinate der Zelle.
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Methode getY()
     * 
     * Ermittelt die y-Koordinate der Zelle.
     *
     * @return Die y-Koordinate der Zelle.
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Methode getNeighbours()
     * 
     * Ruft die Liste der benachbarten Zellen ab.
     *
     * @return Die Liste der benachbarten Zellen.
     */
    @Override
    public List<Cell> getNeighbours() {
        return neighbours;
    }

    /**
     * Methode calculateNextState()
     * 
     * Berechnet den nächsten Zustand der Zelle. 
     * Diese Methode ist abstrakt und muss von Unterklassen implementiert werden.
     */
    @Override
    public abstract void calculateNextState();
}
