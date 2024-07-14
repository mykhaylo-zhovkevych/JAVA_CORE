package snake;

/**
 * Diese Klasse repräsentiert eine Koordinate auf einem Spielfeld.
 * Sie hält eine x- und eine y-Position, welche die Position eines Objekts
 * (z.B. eines Schlangensegments im Snake-Spiel) auf diesem Feld angeben.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class Coordinate {
	/**
     * Die x-Position der Koordinate.
     */
    int x;
    
    /**
     * Die y-Position der Koordinate.
     */
    int y;
    
    /**
     * Konstruktor 
     */
    public Coordinate(int x, int y) {
    	this.x = x;
    	this.y = y;
    	
    }
   
    /**
     * Gibt die x-Position dieser Koordinate zurück.
     * 
     * @return Die x-Position der Koordinate.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Gibt die y-Position dieser Koordinate zurück.
     * 
     * @return Die y-Position der Koordinate.
     */
    public int getY() {
        return y;
    }
    
    // TODO Start Teilaufgabe 5
    
    /**
     * Setter x und y  
     */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    // TODO End Teilaufgabe 5
}



