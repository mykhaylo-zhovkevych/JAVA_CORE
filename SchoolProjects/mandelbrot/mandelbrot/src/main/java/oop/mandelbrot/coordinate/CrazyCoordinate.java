package oop.mandelbrot.coordinate;


/**
 * Diese Klasse repräsentiert einen zweidimensionalen Punkt mit x und y Koordinaten
 * Sie bietet Methoden zum Addieren, Multiplizieren und Berechnen des Skalarbetrags von 
 * CrazyCoordinate Objekten
 *
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class CrazyCoordinate {
    double x;  // Package-private (default) access
    double y;  // Package-private (default) access

    /**
     * Ich finde die Aufgabenstellung recht einfach mit dieser Beschreibung von 2 musste ich nicht viel machen
     * Ich kann zumindest erklären, was der Code macht.
     * 
     * Konstruktur für die double x und double y
     * diese Konstruktor initialisiert die x und y 
     * 
     * @param double x
     * @param double y 
     * 
     **/
    public CrazyCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Da die Methode CrazyCoordinate akzeptiert die Objekct other von CrazyCoordinate
     * und hier wird die neue wert für y und x ertellt und retourniert, als neue CrazyCoordinate Objekt
     * 
     * @param other y, x
     * @return Eine neue CrazyCoordinate, die die Summe der beiden Koordinaten darstellt
     */
    public CrazyCoordinate add(CrazyCoordinate other) {
        return new CrazyCoordinate(this.x + other.x, this.y + other.y);
    }

    /**
     * In diese Methode wird die y und x mit andere x, y multipliziert, subtrahiert und addiert
     * 
     * @param other y, x 
     * @return Eine neue CrazyCoordinate, die das Produkt der beiden Koordinaten darstellt     
     * */
    public CrazyCoordinate mul(CrazyCoordinate other) {
        return new CrazyCoordinate(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x);
    }

    /**
     * Diese methode gibt Quadratwurzel von y und x zurück.
     * 
     * @return x^2, y^2
     */
    public double scalar() {
    	 return (this.x * this.x + this.y * this.y);
    }
    /**
     * Gibt die x-Koordinate zurück.
     * 
     * @return Die x-Koordinate
     */
    public double getX() {
    	return x ;
    }
    /**
     * Gibt die y-Koordinate zurück.
     * 
     * @return Die y-Koordinate
     */
    public double getY() {
    	return y;
    }
    @Override
    public String toString() {
    	return "(" + x + ", " + y + ")";
    }
}

