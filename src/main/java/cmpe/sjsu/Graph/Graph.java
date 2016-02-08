package cmpe.sjsu.Graph;

/**
 * Created by Naks on 16-Jan-16.
 * http://www.geeksforgeeks.org/union-find/
 */
public class Graph {

    private int vertices, edges;
    private Edge edgesOfGraph[];

    // Creates a graph with V vertices and E edges
    Graph(int noOfVertices, int noOfEdges) {
        vertices = noOfVertices;
        edges = noOfEdges;
        edgesOfGraph = new Edge[edges];

        for (int i = 0; i < edges; i++)
            edgesOfGraph[i] = new Edge();
    }

    // function to find the subset of an element i
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void union(int parent[], int src, int dest) {
        int srcSet = find(parent, src);
        int destSet = find(parent, dest);

        parent[srcSet] = destSet;
    }

    public boolean isCyclic(Graph graph) {
        // Allocate memory for creating V subsets
        int parent[] = new int[graph.vertices];

        // Initialize all subsets as single element sets
        for (int i = 0; i < graph.vertices; i++)
            parent[i] = -1;

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.edges; i++) {
            int x = graph.find(parent, graph.edgesOfGraph[i].getSrc());
            int y = graph.find(parent, graph.edgesOfGraph[i].getDest());

            if (x == y)
                return true;
            graph.union(parent, x, y);
        }
        return false;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public Edge[] getEdgesOfGraph() {
        return edgesOfGraph;
    }

    public void setEdgesOfGraph(Edge[] edgesOfGraph) {
        this.edgesOfGraph = edgesOfGraph;
    }

    public void print() {
        System.out.print("\n");
        for (int i = 0; i < edges; i++)
            System.out.println(getEdgesOfGraph()[i].getSrc() + "-" + getEdgesOfGraph()[i].getDest() + "=" + getEdgesOfGraph()[i].getWeight());
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edgesOfGraph[0].setSrc(0);
        graph.edgesOfGraph[0].setDest(1);

        // add edge 1-2
        graph.edgesOfGraph[1].setSrc(1);
        graph.edgesOfGraph[1].setSrc(2);

        // add edge 0-2
        graph.edgesOfGraph[2].setSrc(0);
        graph.edgesOfGraph[2].setDest(2);

        if (graph.isCyclic(graph))
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
