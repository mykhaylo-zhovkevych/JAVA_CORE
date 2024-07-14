package graphs;

import java.util.Objects;

/**
 * Die Klasse Edge ist für die Initialisierung der Kante zwischen Knoten verantwortlich.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0 
 * 
 */
public class Edge {
     int v;
     int w;

    /**
     * Konstruktor zur Initialisierung einer Kante zwischen zwei Knoten.
     *
     * @param v Der erste Knoten.
     * @param w Der zweite Knoten.
     */
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    /**
     * Gibt den ersten Knoten der Kante zurück.
     *
     * @return Der erste Knoten.
     */
    public int getV() {
        return v;
    }

    /**
     * Gibt den zweiten Knoten der Kante zurück.
     *
     * @return Der zweite Knoten.
     */
    public int getW() {
        return w;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return v == edge.v && w == edge.w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, w);
    }
}