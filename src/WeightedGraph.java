import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> adjacencyMap;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacencyMap.putIfAbsent(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        addVertex(source);
        addVertex(destination);

        if (hasEdge(source, destination) || source.equals(destination)) {
            return; // reject parallel edges & self-loops
        }

        adjacencyMap.get(source).add(new Edge<>(source, destination, weight));
        if (undirected) {
            adjacencyMap.get(destination).add(new Edge<>(destination, source, weight));
        }
    }

    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    public int getEdgesCount() {
        int count = adjacencyMap.values().stream().mapToInt(List::size).sum();
        return undirected ? count / 2 : count;
    }

    public boolean hasVertex(Vertex vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        return hasVertex(source) && adjacencyMap.get(source).contains(new Edge<>(source, destination));
    }

    public List<Vertex> getAdjacencyList(Vertex vertex) {
        if (!hasVertex(vertex)) {
            return Collections.emptyList();
        }
        List<Vertex> adjacentVertices = new LinkedList<>();
        for (Edge<Vertex> edge : adjacencyMap.get(vertex)) {
            adjacentVertices.add(edge.getDestination());
        }
        return adjacentVertices;
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex vertex) {
        return hasVertex(vertex) ? adjacencyMap.get(vertex) : Collections.emptyList();
    }
}
