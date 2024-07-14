package interfaces;

/**
 * Die Interface AdjIterator bietet eine Abstraktensebene, die unabhängig von der internen Darstellung des Graphen ist und ist benutzt, um durch die Nachbarn eines Knotens in einem Graphen zu iterieren.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0 
 * 
 */
public interface AdjIterator {

	/**
     * Gibt den ersten Nachbarn des aktuellen Knotens zurück.
     * 
     * @return Der erste Nachbar des Knotens, oder -1, wenn keine Nachbarn vorhanden sind.
     */
	int first();
	
	/**
     * Gibt den nächsten Nachbarn des aktuellen Knotens zurück.
     * 
     * @return Der nächste Nachbar des Knotens, oder -1, wenn keine weiteren Nachbarn vorhanden sind.
     */
	
	 /**
     * Prüft, ob das Ende der Nachbarschaftsliste erreicht ist.
     * 
     * @return true, wenn das Ende der Nachbarschaftsliste erreicht ist, andernfalls false.
     */
    int next();
    boolean end();
}
