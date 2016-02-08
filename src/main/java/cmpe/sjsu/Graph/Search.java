package cmpe.sjsu.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Naks on 14-Jan-16.
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * Time Complexity = O(E+V)
 */
public class Search {

    LinkedList<Integer>[] adjList;

    Search(DiGraph diGraph) {
        adjList = diGraph.getAdjList();
    }

    public void GraphBFS(int source, int vertices) {
        // 1. Mark all the vertices as not visited(By default set as false or zero)
        boolean visited[] = new boolean[vertices];

        // 2. Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // 3. Mark the current/starting node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            source = queue.poll(); // remove from queue
            System.out.print(source + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> it = adjList[source].listIterator();

            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSRecur(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSRecur(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void GraphDFS(int source, int vertices) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertices];

        // Call the recursive helper function to print DFS traversal
        DFSRecur(source, visited);
    }

    public static void main(String args[]) {
        DiGraph g = new DiGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        Search graphSearch = new Search(g);
        System.out.println("Breadth First Traversal");
        graphSearch.GraphBFS(2, g.getV());

        System.out.println("\nDepth First Traversal");
        graphSearch.GraphDFS(2, g.getV());
    }
}
