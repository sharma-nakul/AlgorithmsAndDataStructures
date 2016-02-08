package cmpe.sjsu.BinaryTree;

/**
 * Created by Naks on 15-Jan-16.
 * http://geeksquiz.com/binary-tree-set-1-introduction/
 */
public class Node {
    public int key;
    public Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
