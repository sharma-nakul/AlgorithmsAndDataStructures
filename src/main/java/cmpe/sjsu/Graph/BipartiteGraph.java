package cmpe.sjsu.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Naks on 15-Jan-16.
 * <p>
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every
 * edge (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v),
 * either u belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects
 * vertices of same set.
 * <p>
 * http://www.geeksforgeeks.org/bipartite-graph/
 */
public class BipartiteGraph {

    LinkedList<Integer>[] adjList;
    int vertices;

    BipartiteGraph(DiGraph diGraph) {
        adjList = diGraph.getAdjList();
        vertices = diGraph.getV();
    }

    boolean isBipartite(int src) {
        int color[] = new int[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; ++i)
            color[i] = -1;
        //Start with assigning color to source
        color[src] = 1;
        queue.add(src);

        while (queue.size() != 0) {
            //Dequeue vertex from the queue
            int u = queue.poll();

            //Find all uncolored adjacent vertices and color them with opposite color.
            Iterator<Integer> it = adjList[vertices - 1].listIterator();
            while (it.hasNext()) {
                int v = it.next();
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u])
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        DiGraph g = new DiGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 2);
        BipartiteGraph bipartiteGraph = new BipartiteGraph(g);
        if (bipartiteGraph.isBipartite(0))
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is not Bipartite");
    }
}
