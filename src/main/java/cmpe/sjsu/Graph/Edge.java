package cmpe.sjsu.Graph;

/**
 * Created by Naks on 16-Jan-16.
 * http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 */
public class Edge implements Comparable<Edge> {
    private int src, dest, weight;

    //Sort according to weight of edge
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void print() {
        System.out.println(src + "-" + dest + " = " + weight);
    }
}
