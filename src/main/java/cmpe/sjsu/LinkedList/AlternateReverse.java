/**
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
 * You are required do this in-place without altering the nodes’ values.
 * <p>
 * Examples:
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 1 -> 4 -> 2 -> 3
 * <p>
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 * <p>
 * Solution:
 * 1) Find the middle point using tortoise and hare method.
 * 2) Split the linked list in two halves using found middle point in step 1.
 * 3) Reverse the second half.
 * 4) Do alternate merge of first and second halves.
 **/

package cmpe.sjsu.LinkedList;

/**
 * Created by Naks on 25-Oct-15.
 **/
public class AlternateReverse {

    private Node list;
    private Node newList;

    public AlternateReverse(Node linkedList) {
        this.list = linkedList;
        this.newList = new Node(0);
    }

    /**
     * This method perform following operations
     * 1. Find middle of a Linked List if size count is not given
     * 2. Reverse second half of Linked List
     * 3. Finally merge original order of first half with reverse order of second half.
     */
    public void SplitAndMerge() {
        Node middle = TortoiseHareMethod(list);
        System.out.println("After Finding Middle");
        dispay(middle.getNext());

        Node lNode = list.getNext();
        Node rNode = middle.getNext();
        middle.setNext(null);

        System.out.println("After Reversing Right Side");
        Node reverseList = reverseLinkedList(rNode);
        if (reverseList == null)
            return;
        dispay(reverseList);

        Node current = newList; // store newList start point in current node
        while (lNode != null || reverseList != null) {
            if (lNode != null) {
                current.setNext(lNode);
                lNode = lNode.getNext();
                current = current.getNext();
            }
            if (reverseList != null) {
                current.setNext(reverseList);
                reverseList = reverseList.getNext();
                current = current.getNext();
            }
        }
        newList = newList.getNext(); // assign head to new list
        System.out.println("After Merging of Both List");
        dispay(newList);
    }

    /**
     * The method to reverse the list such that starting point is null and end point in head.
     *
     * @param listToReverse Pass the list that needs to be reversed.
     */
    public Node reverseLinkedList(Node listToReverse) {
        Node previous = null, current = listToReverse, nextNode;
        if (listToReverse != null) {
            while (current != null) {
                nextNode = current.getNext(); // next node address is saved before breaking the link
                current.setNext(previous); // current node point to previous
                previous = current; // shift 1 step ahead
                current = nextNode; // shift 1 step ahead
            }
            listToReverse = previous;  // this is starting point of list (i.e. head)
            return listToReverse;
        } else
            return null;
    }

    /**
     * Method to find the middle point of linked list using Tortoise and Hare Method
     * @param listHead This is a Linked List for which middle point needs to be identified.
     * @return It returns middle node. Its type is Node
     */
    public Node TortoiseHareMethod(Node listHead) {
        Node current = listHead;
        Node slow = current;
        Node fast = current;
        while (fast != null && fast.getNext() != null) // to check 2 move is not null as fast node is moving 2 steps
        {
            slow = slow.getNext(); // move 1 steps
            fast = fast.getNext().getNext(); // move 2 steps
        }
        return slow; // this is mid point of list.
    }

    private void dispay(Node listName) {
        int i = 1;
        while (listName != null) {
            System.out.println("Node " + i++ + " -> " + listName.getData());
            listName = listName.getNext();
        }
    }
}
