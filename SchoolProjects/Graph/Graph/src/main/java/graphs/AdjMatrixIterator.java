package graphs;

import interfaces.AdjIterator;

/**
 * Die Klasse AdjMatrixIterator bietet eine Implementierung des AdjIterator Interfaces 
 * für einen AdjMatrixGraph.
 * 
 * <p>Dieser Iterator ermöglicht das Durchlaufen der Nachbarn eines Knotens in einem Adjazenzmatrix Graphen.</p>
 * 
 * @autor Mykhaylo Zhovkevych
 * @version 1.0 
 */
public class AdjMatrixIterator implements AdjIterator {
	
    private AdjMatrixGraph graph;
    private int v;
    private int current;

    /**
     * Konstruktor zur Initialisierung eines Adjazenzmatrix Iterators für einen bestimmten Knoten.
     *
     * @param graph Der Adjazenzmatrix Graph, durch den iteriert wird.
     * @param v Der Knoten, dessen Nachbarn iteriert werden.
     */
    public AdjMatrixIterator(AdjMatrixGraph graph, int v) {
        this.graph = graph;
        this.v = v;
        this.current = -1;
    }

    /**
     * Gibt den ersten Nachbarn des aktuellen Knotens zurück und setzt den aktuellen Index auf den Anfang.
     *
     * @return Der erste Nachbar des Knotens, oder -1, wenn keine Nachbarn vorhanden sind.
     */
    @Override
    public int first() {
        current = 0;
        return next();
    }

    /**
     * Gibt den nächsten Nachbarn des aktuellen Knotens zurück.
     *
     * @return Der nächste Nachbar des Knotens, oder -1, wenn keine weiteren Nachbarn vorhanden sind.
     */
    @Override
    public int next() {
        while (current < graph.nofVertices()) {
            if (graph.adjMatrix[v][current]) {
                return current++;
            }
            current++;
        }
        return -1;  
    }

    /**
     * Prüft, ob das Ende der Nachbarschaftsliste erreicht ist.
     *
     * @return true, wenn das Ende der Nachbarschaftsliste erreicht ist, andernfalls false.
     */
    @Override
    public boolean end() {
        return current >= graph.nofVertices();
    }
}

