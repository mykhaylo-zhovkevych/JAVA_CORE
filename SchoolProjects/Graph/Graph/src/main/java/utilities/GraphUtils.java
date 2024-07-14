package utilities;

import interfaces.Graph;
import java.util.Random;
import interfaces.AdjIterator;
import graphs.Edge;

/**
 * Die Klasse GraphUtils stellt zur Verfügung die Methoden zur Ausgabe und Erstellung von Graphen.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0 
 */
public class GraphUtils {
	
	/**
     * Gibt den Graphen auf der Konsole aus.
     * Jeder Knoten und seine verbundenen Kanten werden angezeigt.
     * 
     * @param graph Der zu druckende Graph.
     */
	 static void printGraph(Graph graph) {
        for (int v = 0; v < graph.nofVertices(); v++) {
            AdjIterator it = graph.getAdjIterator(v);
            System.out.print(v + ": ");
            for (int w = it.first(); w != -1; w = it.next()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

	/**
     * Erstellt einen zufälligen Graphen mit einer angegebenen Anzahl von Kanten.
     * Kanten werden zufällig zwischen den Knoten eingefügt, wobei keine v = w erlaubt ist.
     * 
     * @param graph Der Graph, dem Kanten hinzugefügt werden.
     * @param nofEdges Die Anzahl der hinzuzufügenden Kanten.
     */
     static void randomGraph(Graph graph, int nofEdges) {
        Random random = new Random();
        int vertices = graph.nofVertices();
        while (graph.nofEdges() < nofEdges) {
            int v = random.nextInt(vertices);
            int w = random.nextInt(vertices);
            if (v != w) {
                graph.insert(new Edge(v, w));
            }
        }
    }
}