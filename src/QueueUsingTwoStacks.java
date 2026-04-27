import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;




public class QueueUsingTwoStacks {

    private Stack<T> inputStack = new Stack<>();
    private Stack<T> outputStack = new Stack<>();

    public void enqueue(T element) {
        inputStack.push(element);
        System.out.println("Enqueued: " + element);
        showState();
    }
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue.");
            return null;
        }
        transferIfNeeded();
        T val = outputStack.pop();
        System.out.println("Dequeued: " + val);
        showState();
        return val;
    }






}
