package cmpe.sjsu.LinkedList;

/**
 * Created by Naks on 25-Oct-15.
 * Class to implement Doubly Linked List
 */
public class DoubleLinkedList {

    private Node head;
    private static int listCount;

    public Node getHead() {
        return head;
    }

    public DoubleLinkedList() {
        head = new Node(null); // defining start of linked list for iteration
        listCount = 0;
    }


    public void insertAtIndex(Node newNode, int index) {
        if (head.getNext()== null)
        {
            head.setNext(newNode);
            newNode.setPrevious(head);
            display(newNode);
        }

        else
        {
            Node previousNode = findNode(index);
            if (previousNode== null) {
                System.out.println("Null Node Found");
                return;
            }
            newNode.setNext(previousNode.getNext());
            newNode.setPrevious(previousNode);
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

    public Node findNode(int index) {
        Node searchedNode = head;
        if (index != 0 || index < getListCount()) {
            for (int i = 0; i < index; i++)
                searchedNode = searchedNode.getNext();
            return searchedNode;
        }
        return head;
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
