package components;

import interfaces.Graph;
import interfaces.AdjIterator;
import java.util.Arrays;


/**
 * Die Klasse ConnectedComponents analysiert einen gegebenen Graphen, um seine verbundenen Komponenten zu bestimmen.
 *
 * @author Mykhaylo Zhovkevych
 * @version 1.0  
 * 
 */
public class ConnectedComponents {
    private Graph graph;
    private int count;
    private int[] ids;
    private boolean[] visited;

    /**
     * Konstruktor für ein ConnectedComponents Objekt für einen gegebenen Graphen.
     *
     * @param graph Der zu analysierende Graph.
     */
    public ConnectedComponents(Graph graph) {
        this.graph = graph;
        this.ids = new int[graph.nofVertices()];
        this.visited = new boolean[graph.nofVertices()];
        // Initialisiert mit einem Standardwert, wie -1 oder false, was leer bedeutet
        Arrays.fill(ids, -1);
        Arrays.fill(visited, false);
        this.count = 0;
        for (int v = 0; v < graph.nofVertices(); v++) {
            if (!visited[v]) {
                identifyComponent(v);
                count++;
            }
        }
    }

    /**
     * Führt eine Suche durch, um alle Knoten zu identifizieren,
     * die in der gleichen verbundenen Komponente wie der gegebene Knoten sind.
     * Markiert den Knoten als besucht und weist ihm die aktuelle Komponenten ID zu.
     *
     * @param v Der Knoten, von dem aus die Suche gestartet wird.
     */
    private void identifyComponent(int v) {
        visited[v] = true;
        ids[v] = count;
        AdjIterator it = graph.getAdjIterator(v);
        for (int w = it.first(); w != -1; w = it.next()) {
            if (!visited[w]) {
                identifyComponent(w);
            }
        }
    }

    /**
     * Gibt die Anzahl der verbundenen Komponenten im Graphen zurück.
     *
     * @return Die Anzahl der verbundenen Komponenten.
     */
    public int getCount() {
        return count;
    }

    /**
     * Bestimmt, ob zwei Knoten in der gleichen verbundenen Komponente sind.
     *
     * @param v Der erste Knoten.
     * @param w Der zweite Knoten.
     * @return true, wenn die Knoten in der gleichen verbundenen Komponente sind, andernfalls false.
     */
    public boolean isConnected(int v, int w) {
        return ids[v] == ids[w];
    }
}
