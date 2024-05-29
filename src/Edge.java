import java.util.Objects;

public class Edge<Vertex> {
    private final Vertex source;
    private final Vertex destination;
    private  double weight;

    public Edge(Vertex source, Vertex destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex destination) {
        this.source= source;
        this.destination= destination;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Double.compare(edge.weight, weight) == 0 &&
                Objects.equals(source, edge.source) &&
                Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }
}
