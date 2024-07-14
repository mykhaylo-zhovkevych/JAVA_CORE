package utilities;

import interfaces.AdjIterator;
import interfaces.Graph;
import graphs.AdjMatrixGraph;
import graphs.AdjListGraph;
import graphs.Edge;
import graphs.GraphDegrees;
import components.ConnectedComponents;

public class Main {
    public static void main(String[] args) {
        // Gerichteter Graph = true, Ungerichteter Graph = false
        Graph adjMatrixGraph = new AdjMatrixGraph(6, false);
        Graph adjListGraph = new AdjListGraph(6, false);

        GraphUtils.randomGraph(adjMatrixGraph, 6);

        adjListGraph.insert(new Edge(0, 1));
        adjListGraph.insert(new Edge(0, 2));
        adjListGraph.insert(new Edge(1, 2));
        adjListGraph.insert(new Edge(2, 3));
        adjListGraph.insert(new Edge(3, 4));
        adjListGraph.insert(new Edge(4, 5));
        
        System.out.println("Matrix Graph:");
        GraphUtils.printGraph(adjMatrixGraph);
        System.out.println("List Graph:");
        GraphUtils.printGraph(adjListGraph);
        
        printBreakLine();
        
        GraphDegrees degreesMatrix = new GraphDegrees(adjMatrixGraph);
        GraphDegrees degreesList = new GraphDegrees(adjListGraph);

        System.out.println("Grad in Matrix Graph:");
        for (int i = 0; i < adjMatrixGraph.nofVertices(); i++) {
            System.out.println("Vertex " + i + " hat Grad " + degreesMatrix.degree(i));
        }
        
        printBreakLine();
        
        System.out.println("Grad in List Graph:");
        for (int i = 0; i < adjListGraph.nofVertices(); i++) {
            System.out.println("Vertex " + i + " hat Grad " + degreesList.degree(i));
        }
        
        printBreakLine();
       
        ConnectedComponents componentsMatrix = new ConnectedComponents(adjMatrixGraph);
        ConnectedComponents componentsList = new ConnectedComponents(adjListGraph);
        System.out.println("Verbundene Komponenten in Matrix Graph: " + componentsMatrix.getCount());
        System.out.println("Verbundene Komponenten in List Graph: " + componentsList.getCount());
  
        printBreakLine();
        
        adjMatrixGraph.remove(new Edge(0, 1));
        adjMatrixGraph.remove(new Edge(0, 2));
        adjMatrixGraph.remove(new Edge(1, 2));
        adjMatrixGraph.remove(new Edge(2, 3));
        
        adjListGraph.remove(new Edge(1, 2));
        adjListGraph.remove(new Edge(2, 3));
        adjListGraph.remove(new Edge(3, 4));
        
        System.out.println("Matrix Graph nach remove:");
        GraphUtils.printGraph(adjMatrixGraph);
        System.out.println("List Graph nach remove:");
        GraphUtils.printGraph(adjListGraph);
    
    }
    
    public static void printBreakLine() {
        System.out.println("----------------------------------------");
    }
}


