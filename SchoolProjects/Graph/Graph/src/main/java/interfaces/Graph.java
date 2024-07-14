package interfaces;

import graphs.Edge;


/**
 * Die Interface Graph stellt zur Verfügung die allgemeine Methoden für Graphen.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0 
 * 
 */
public interface Graph {
	
// Den Graphen als eine Ansammlung von Punkten (Knoten) vorstellen, die durch Linien (Kanten) miteinander verbunden sind.	
		int nofVertices();
	    int nofEdges();
	    boolean isDirected();
	    void insert(Edge edge);
	    void remove(Edge edge);
	    boolean hasEdge(int v, int w);
	    AdjIterator getAdjIterator(int v);
}
