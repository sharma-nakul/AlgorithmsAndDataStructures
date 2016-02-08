package cmpe.sjsu.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Naks on 14-Jan-16.
 * http://www.geeksforgeeks.org/graph-and-its-representations/
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
public class DiGraph {

    private int V;   // No. of vertices in a graph
    private LinkedList<Integer> adjList[]; //Adjacency Lists (nodes that are connected to a node in LL)

    DiGraph(int v)
    {
        V = v;
        adjList = new LinkedList[v];  // initializing vertical linked list
        for (int i=0; i<v; ++i)
            adjList[i] = new LinkedList();  // initializing horizontal linked list
    }

    private boolean isCyclicRecur(int vertex, boolean visited[], boolean recordStack[]) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            recordStack[vertex] = true;
        }
        Iterator<Integer> i = adjList[vertex].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n] && isCyclicRecur(n, visited, recordStack))
                return true; // if cycle present
            else if (recordStack[n])
                return true;
        }
        recordStack[vertex]=false;
        return false;
    }

    public boolean isCyclic(int vertices) {
        boolean visited[] = new boolean[vertices];
        boolean recordStack[] = new boolean[vertices];
        for (int vertex = 0; vertex < vertices; vertex++)
            if (isCyclicRecur(vertex, visited, recordStack))
                return true;
        return false;
    }

    public void addEdge(int v,int w)
    {
        adjList[v].add(w);
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList<Integer>[] adjList) {
        this.adjList = adjList;
    }

    public static void main(String args[]) {
        DiGraph g = new DiGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
       if(g.isCyclic(g.getV()))
            System.out.println("Cycle is present");
        else
            System.out.println("Cycle is not present");
    }

}
