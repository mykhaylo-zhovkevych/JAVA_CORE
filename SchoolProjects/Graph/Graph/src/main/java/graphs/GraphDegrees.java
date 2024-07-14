package graphs;

import interfaces.AdjIterator;
import interfaces.Graph;

/**
 * Die Klasse GraphDegrees berechnet und speichert die Grade (Anzahl der Kanten) für jeden Knoten in einem gegebenen Graphen.
 * 
 * <p>Diese Klasse ermöglicht es, den Grad eines bestimmten Knotens schnell abzurufen.</p>
 * 
 * @autor Mykhaylo Zhovkevych
 * @version 1.0 
 */
public class GraphDegrees {
    private Graph graph;
    private int[] degrees;

    /**
     * Konstruktor für ein GraphDegrees Objekt.
     * Berechnet die Grade für jeden Knoten im gegebenen Graphen und speichert sie.
     *
     * @param graph Der zu analysierende Graph.
     */
    public GraphDegrees(Graph graph) {
        this.graph = graph;
        this.degrees = new int[graph.nofVertices()];
        calculateDegrees();
    }

    /**
     * Berechnet die Grade für jeden Knoten im Graphen.
     * Diese Methode durchläuft alle Knoten und zählt die Anzahl der Kanten für jeden Knoten.
     */
    private void calculateDegrees() {
        for (int v = 0; v < graph.nofVertices(); v++) {
            AdjIterator it = graph.getAdjIterator(v);
            for (int w = it.first(); w != -1; w = it.next()) {
                degrees[v]++;
            }
        }
    }

    /**
     * Gibt den Grad des angegebenen Knotens zurück.
     *
     * @param v Der Knoten, dessen Grad abgefragt wird.
     * @return Der Grad des Knotens.
     */
    public int degree(int v) {
        return degrees[v];
    }
}

