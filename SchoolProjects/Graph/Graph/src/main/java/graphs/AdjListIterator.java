package graphs;

import interfaces.AdjIterator;
import java.util.Iterator;
import java.util.List;


/**
 * Dieser Iterator ermöglicht das Durchlaufen der Nachbarn eines Knotens in einem Adjazenzlisten Graphen.
 * 
 * @autor Mykhaylo Zhovkevych
 * @version 1.0 
 */
public class AdjListIterator implements AdjIterator {
	
	// Eine Liste von ganzen Zahlen
    private List<Integer> adjList;
    // Iterator wird verwendet, um die Adjazenzliste zu durchlaufen(iterate)
    private Iterator<Integer> it;

    /**
     * Konstruktor zur Initialisierung eines Adjazenzlisten Iterators.
     *
     * @param adjList Die Adjazenzliste, durch die iteriert wird.
     */
    public AdjListIterator(List<Integer> adjList) {
        this.adjList = adjList;
        this.it = adjList.iterator();
    }

    /**
     * Gibt den ersten Nachbarn des aktuellen Knotens zurück und setzt den Iterator auf den Anfang der Adjazenzliste zurück.
     *
     * @return Der erste Nachbar des Knotens, oder -1, wenn keine Nachbarn vorhanden sind.
     */
    @Override
    public int first() {
    	// (optional) setzt den Iterator auf den Anfang der Adjazenzliste zurück
    	this.it = adjList.iterator();  
    	
        if (it.hasNext()) {
            return it.next();
        } else {
            return -1;
        }
    }

    /**
     * Gibt den nächsten Nachbarn des aktuellen Knotens zurück.
     *
     * @return Der nächste Nachbar des Knotens, oder -1, wenn keine weiteren Nachbarn vorhanden sind.
     */
    @Override
    public int next() {
        if (it.hasNext()) {
            return it.next();
        } else {
            return -1;  
        }
    }

    /**
     * Prüft, ob das Ende der Nachbarschaftsliste erreicht ist.
     *
     * @return true, wenn das Ende der Nachbarschaftsliste erreicht ist, andernfalls false.
     */
    @Override
    public boolean end() {
        return !it.hasNext();
    }
}
