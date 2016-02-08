package cmpe.sjsu.Graph;

import java.util.Arrays;

/**
 * Created by Naks on 16-Jan-16.
 * http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 */
public class SpanningTree {


    //To check whether forms a cycle by storing edge information temporary
    class Subset {
        int parentNode;
        int rank;
    }

    ;
/*---------------------------------- Kruskal Algorithm ------------------------------------ */
    int find(Subset subset[], int i) {
        if (subset[i].parentNode != i)
            subset[i].parentNode = find(subset, subset[i].parentNode);
        return subset[i].parentNode;
    }

    void union(Subset subset[], int x, int y) {
        int xSet = find(subset, x);
        int ySet = find(subset, y);

        if (subset[xSet].rank < subset[ySet].rank)
            subset[xSet].parentNode = ySet;
        else if (subset[xSet].rank > subset[ySet].rank)
            subset[ySet].parentNode = xSet;

        else {
            subset[xSet].parentNode = ySet;
            subset[ySet].rank++;
        }
    }

    public void print(Edge resultantMST[]) {
        for (int i = 0; i < resultantMST.length; i++)
            System.out.println(resultantMST[i].getSrc() + " -- " + resultantMST[i].getDest() + " == " +
                    resultantMST[i].getWeight());
    }

    public Edge[] KruskalAlgorithm(Graph graph) {

        Subset subsets[] = new Subset[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++)
            subsets[i] = new Subset();

        for (int i = 0; i < graph.getVertices(); i++) {
            subsets[i].parentNode = i;
            subsets[i].rank = 0;
        }

        Edge resultantMST[] = new Edge[graph.getVertices()-1];
        for (int i = 0; i < graph.getVertices()-1; i++)
            resultantMST[i] = new Edge();

        Arrays.sort(graph.getEdgesOfGraph());

        int countResultMst = 0, countEdges = 0;
        while (countResultMst < (graph.getVertices() - 1)) {
            Edge nextEdge = graph.getEdgesOfGraph()[countEdges++];
            int x = find(subsets, nextEdge.getSrc());
            int y = find(subsets, nextEdge.getDest());
            if (x != y) {
                resultantMST[countResultMst++] = nextEdge;
                union(subsets, x, y);
            }
            // else discard this edge because it is forming a cycle.
        }
        return resultantMST;
    }

    /*---------------------------------- Prims Algorithm ------------------------------------ */



    int minKeyFinder (int keyMinWeight[], Boolean notInMST[]){
        int tempMinWeight = Integer.MAX_VALUE;
        int minWeightIndex=-1;
        int verticesCount=notInMST.length;

        for(int i=0;i<verticesCount;i++){
            if(keyMinWeight[i]<tempMinWeight&&notInMST[i]==false){
                minWeightIndex=i;
                tempMinWeight=keyMinWeight[i];
            }
        }
        return minWeightIndex;
    }
    public int[] PrimsAlgorithm (Graph graph){

        int V=graph.getVertices(), E=graph.getEdges();
        // Array to store constructed tree
        int constructedTree[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int keyMinWeight[] = new int[V];

        //To represent set of vertices not yet included in MST
        Boolean notInMST[] = new Boolean[V];

        //Initialize all key as INFINITE
        for(int i=0;i<V;i++)
        {
            notInMST[i]=false;
            keyMinWeight[i]=Integer.MAX_VALUE;
        }

        // Always include first 1st vertex in MST.
        keyMinWeight[0] = 0;     // Make key 0 so that this vertex is picked as first vertex
        constructedTree[0] = -1; // First node is always root of MST

        Edge edges[]=graph.getEdgesOfGraph();

        int mstCount=0;
        while(mstCount<V-1)
        {
            int minKeyValue = minKeyFinder(keyMinWeight,notInMST);
            notInMST[minKeyValue]=true; // mark the vertices as true as it is a part of MST now

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int i=0;i<V;i++)
            {
                if (edges[i].getWeight()!=0&&notInMST[i]==false&&edges[i].getWeight()<keyMinWeight[i]){
                constructedTree[i]=edges[i].getSrc();
                    keyMinWeight[i]=edges[i].getWeight();
            }

            }
            mstCount++;
        }

        return constructedTree;
    }

    void printPrimsMst(int constructedTree[], Graph graph)
    {
        for (int i = 1; i < graph.getVertices(); i++)
            System.out.println(constructedTree[i]+" - "+ i+"    "+
                    graph.getEdgesOfGraph()[i].getWeight());
    }

    // Driver Program
    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);
        SpanningTree mst = new SpanningTree();
        Edge edges[] = graph.getEdgesOfGraph();

        // Edge 0 = add edge 0-1
        edges[0].setSrc(0);
        edges[0].setDest(1);
        edges[0].setWeight(10);

        // add edge 0-2
        edges[1].setSrc(0);
        edges[1].setDest(2);
        edges[1].setWeight(6);

        // add edge 0-3
        edges[2].setSrc(0);
        edges[2].setDest(3);
        edges[2].setWeight(5);

        // add edge 1-3
        edges[3].setSrc(1);
        edges[3].setDest(3);
        edges[3].setWeight(15);

        // add edge 2-3
        edges[4].setSrc(2);
        edges[4].setDest(3);
        edges[4].setWeight(4);
        graph.setEdgesOfGraph(edges);

        // The given graph is
        //System.out.println("Given graph is");
        //graph.print();

        //Edge kruskalSpanningTree[] = mst.KruskalAlgorithm(graph);
        int primsSpanningTree[] = mst.PrimsAlgorithm(graph);
        //System.out.println("The Minimum Spanning Tree using Kruskal's Algorithm");
        //mst.print(kruskalSpanningTree);

        System.out.println("The Minimum Spanning Tree using Prim's Algorithm");
        mst.printPrimsMst(primsSpanningTree,graph);


    }
}
