package graphs;

import java.util.*;

import interfaces.AdjIterator;
import interfaces.Graph;

/**
 * Diese Klasse unterstützt sowohl gerichtete als auch ungerichtete Graphen und ermöglicht das Einfügen,
 * Entfernen und Überprüfen von Kanten sowie das Abrufen von Adjazenziteratoren.
 * 
 * @autor Mykhaylo Zhovkevych
 * @version 1.0 
 */
public class AdjListGraph implements Graph {
    private boolean directed;
    private int nofVertices;
    private int nofEdges;
    // Der Schlüssel ist ein Vertex und der Wert ist eine Liste benachbarter Vertices
    private Map<Integer, List<Integer>> adjList;
    private Set<Edge> edges;

    /**
     * Konstruktor zur Initialisierung eines Adjazenzlisten Graphen.
     *
     * @param nofVertices Die Anzahl der Knoten im Graphen.
     * @param directed Gibt an, ob der Graph gerichtet ist.
     */
    public AdjListGraph(int nofVertices, boolean directed) {
        this.nofVertices = nofVertices;
        this.directed = directed;
        this.nofEdges = 0;
        this.adjList = new HashMap<>();
        this.edges = new HashSet<>();
        // leer ArrayLsit hilf gegen NullPointerExceptions
        for (int i = 0; i < nofVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
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
    	// sucht Startpunkt
        int v = edge.getV();
        // sucht Endepunkt
        int w = edge.getW();

        if (!adjList.get(v).contains(w)) {
            adjList.get(v).add(w);
            edges.add(edge);
            // wenn List undirected macht reverse 
            if (!directed) {
                adjList.get(w).add(v);  
                edges.add(new Edge(w, v));
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

        if (adjList.get(v).contains(w)) {
            adjList.get(v).remove((Integer) w);
            edges.remove(edge);
            if (!directed && adjList.get(w).contains(v)) {  
                adjList.get(w).remove((Integer) v);
                edges.remove(new Edge(w, v));
            }
            nofEdges--;
        }
    }

    public boolean hasEdge(int v, int w) {
        return adjList.get(v).contains(w);
    }
   
    public AdjIterator getAdjIterator(int v) {
        return new AdjListIterator(adjList.get(v));
    }
}

