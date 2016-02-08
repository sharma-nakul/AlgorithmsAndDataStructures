package cmpe.sjsu.LinkedList;

public class Node {
    private Node next, previous;
    private Object data;

    public Node(Object dataValue) {
        next = null;
        previous=null;
        this.data = dataValue;
    }

    public Node(Node nextValue, Node previous, int data) {
        this.next = nextValue;
        this.previous=previous;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
