import java.util.*;

public class Search<Vertex> {

    protected Map<Vertex, Vertex> EdgeTo;

    protected Set<Vertex> label;

    protected Vertex source;

    public Search(Vertex source) {
        this.source = source;
        label = new HashSet<>();
        EdgeTo = new HashMap<>();
    }


    public Iterable<Vertex> pathTo(Vertex v) {

        Iterable<Vertex> result = null;
        LinkedList<Vertex> LinkList = new LinkedList<>();

        if (HasPath(v) != false) {
            for (Vertex i = v; i != source; i = EdgeTo.get(i)) {
                LinkList.push(i);
            }
            LinkList.push(source);
            result = LinkList;
        }


        return result;
    }


    public boolean HasPath(Vertex v) {
        return label.contains(v);
    }
}