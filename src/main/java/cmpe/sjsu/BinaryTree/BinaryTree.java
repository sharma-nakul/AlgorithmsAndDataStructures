package cmpe.sjsu.BinaryTree;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Naks on 15-Jan-16.
 * http://geeksquiz.com/binary-tree-set-1-introduction/
 *
 * The maximum number of nodes at level ‘l’ of a binary tree is 2^l-1.
 * Maximum number of nodes in a binary tree of height ‘h’ is 2^(h+1) – 1. Here height of leaf node is 0
 * In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  ? Log2(N+1) ? -1
 * A Binary Tree with L leaves has at least   ? Log2L ? + 1   levels
 * In Binary tree, number of leaf nodes is always one more than nodes with two children.
 */
public class BinaryTree {
    Node root;
    int count=0;
    ArrayList<Integer> maxNodeArray=new ArrayList<>();

    BinaryTree(int key)
    {
        root = new Node(key);
    }

    BinaryTree()
    {
        root = null;
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        TreeMap<Integer, Integer> horizontalTraversal=new TreeMap<>();



        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(root, i);
            maxNodeArray.add(count);
            count=0;
        }
        /* Print Each Level of a tree*/
        /*
        System.out.println(" ");
        for(i=0;i<maxNodeArray.size();i++)
            System.out.println("Level "+i+" = "+maxNodeArray.get(i)); */
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1){
            System.out.print(root.key + " ");
            count++;
        }
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    void swapTreeChildren(Node root) {
        if (root==null)
            return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        swapTreeChildren(root.left);
        swapTreeChildren(root.right);
    }

    int diameter(Node root)
    {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));

    }

    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        return diameter(root);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

       // tree.printLevelOrder();
        tree.swapTreeChildren(tree.root);
        tree.printLevelOrder();
    }
}
