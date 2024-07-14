package graphs;

import interfaces.AdjIterator;
import interfaces.Graph;

/**
 * Eine quadratische Matrix, bei der die Zeilen und Spalten Knoten repräsentieren und die Einträge anzeigen, ob eine Kante zwischen zwei Knoten existiert.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0 
 * 
 * */
public class AdjMatrixGraph implements Graph {
    private boolean directed;
    // Die Anzahl der Knoten im Graphen
    private int nofVertices;
    // Die Anzahl der Kanten im Graphen
    private int nofEdges;
    final boolean[][] adjMatrix;

    /**
     * Konstruktor zur Initialisierung eines Adjazenzmatrix Graphen.
     *
     * @param nofVertices Die Anzahl der Knoten im Graphen.
     * @param directed Gibt an, ob der Graph gerichtet ist.
     */
    public AdjMatrixGraph(int nofVertices, boolean directed) {
        this.nofVertices = nofVertices;
        this.directed = directed;
        this.nofEdges = 0;
        this.adjMatrix = new boolean[nofVertices][nofVertices];
    }

    /**
     * Gibt die Anzahl der Knoten im Graphen zurück.
     *
     * @return Die Anzahl der Knoten.
     */
    public int nofVertices() {
        return nofVertices;
    }

    /**
     * Gibt die Anzahl der Kanten im Graphen zurück.
     *
     * @return Die Anzahl der Kanten.
     */
    public int nofEdges() {
        return nofEdges;
    }

    /**
     * Gibt an, ob der Graph gerichtet ist.
     *
     * @return true, wenn der Graph gerichtet ist, andernfalls false.
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Fügt eine Kante zwischen zwei Knoten in den Graphen ein.
     * Wenn die Kante bereits existiert, wird keine Aktion durchgeführt.
     *
     * @param edge Die einzufügende Kante.
     */
    public void insert(Edge edge) {
        int v = edge.getV();
        int w = edge.getW();
        // Überprüft, ob bereits eine Kante von v nach w existiert
        if (!adjMatrix[v][w]) {
            adjMatrix[v][w] = true;
            // Überprüft, ob der Graph ungerichtet ist wenn ja dann jede Kante sind bidirektional 
            if (!directed) {
                adjMatrix[w][v] = true;
            }
            nofEdges++;
        }
    }

    /**
     * Entfernt eine Kante zwischen zwei Knoten aus dem Graphen.
     * Wenn die Kante nicht existiert, wird keine Aktion durchgeführt.
     *
     * @param edge Die zu entfernende Kante.
     */
    public void remove(Edge edge) {
        int v = edge.getV();
        int w = edge.getW();
        if (adjMatrix[v][w]) {
            adjMatrix[v][w] = false;
            if (!directed) {
                adjMatrix[w][v] = false;
            }
            nofEdges--;
        }
    }

    /**
     * Überprüft, ob eine Kante zwischen zwei Knoten existiert.
     *
     * @param v Der Startknoten.
     * @param w Der Endknoten.
     * @return true, wenn eine Kante existiert, andernfalls false.
     */
    public boolean hasEdge(int v, int w) {
        return adjMatrix[v][w];
    }

    /**
     * Gibt einen Adjazenziterator für einen bestimmten Knoten zurück.
     *
     * @param v Der Knoten, für den der Iterator zurückgegeben wird.
     * @return Der Adjazenziterator.
     */
    public AdjIterator getAdjIterator(int v) {
        return new AdjMatrixIterator(this, v);
    }
}