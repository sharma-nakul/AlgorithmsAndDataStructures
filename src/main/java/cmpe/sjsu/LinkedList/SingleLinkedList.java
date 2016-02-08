package cmpe.sjsu.LinkedList;

/**
 * Created by nakulsharma on 10/16/15.
 * Implementation of Singly Linked with all its operations.
 */
public class SingleLinkedList {
    private Node head;
    private static int listCount;

    public Node getHead() {
        return head;
    }

    public SingleLinkedList() {
        head = new Node(null); // defining start of linked list for iteration
        listCount = 0;
    }

    public Node findNode(int index) {
        Node searchedNode = head;
        if (index != 0 || index < getListCount()) {
            for (int i = 0; i < index; i++)
                searchedNode = searchedNode.getNext();
            return searchedNode;
        }
        return null;
    }

    public void insertAtIndex(Node newNode, int index) {
        if (head.getNext() == null) {// First node after head is null
            head.setNext(newNode);
        } else {
            Node currentNode = findNode(index);
            if (currentNode == null) {
                System.out.println("Null Node Found");
                return;
            }
            newNode.setNext(currentNode.getNext()); // next link of new node is next link of current node
            currentNode.setNext(newNode); // next link of current node is new node
        }
        listCount++;
    }


    public void insertAtStart(Node newNode) {
        insertAtIndex(newNode, 1);
    }

    public void insertAtEnd(Node newNode) {
        int count = getListCount();
        insertAtIndex(newNode,count);
    }

    public void remove(int index) {
        Node temp = findNode(index - 1);
        temp.setNext(temp.getNext().getNext());
        listCount--;
    }

    public void display(Node headOfList) {
        Node temp = headOfList.getNext();
        int i=1;
        while(temp!=null) {
            System.out.println("Node " + i++ + " is -> " + temp.getData());
            temp = temp.getNext();
        }
    }

    public int getListCount() {
        return listCount;
    }
}

