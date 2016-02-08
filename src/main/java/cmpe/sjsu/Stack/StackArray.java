package cmpe.sjsu.Stack;

/**
 * Created by Naks on 26-Oct-15.
 * Stack Implementation using array
 */
public class StackArray  {

    private int maxSize;
    private Object [] stackArray;
    private int top;

    public StackArray (){}
    public StackArray(int s) {
        maxSize = s;
        stackArray = new Object[maxSize];
        top = -1;
    }
    public void push(Object j)
    {
        stackArray[++top] = j;
    }
    public Object pop() {
        return stackArray[top--];
    }
    public Object peek() {
        return stackArray[top];
    }
    public boolean isEmptyStack() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public Object[] getStackArray() {
        return stackArray;
    }

    public void setStackArray(Object[] stackArray) {
        this.stackArray = stackArray;
    }
}
