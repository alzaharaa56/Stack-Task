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
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot peek.");
            return null;
        }
        transferIfNeeded();
        T val = outputStack.peek();
        System.out.println("Peeked: " + val);
        showState();
        return val;
    }
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public int size() {
        return inputStack.size() + outputStack.size();
    }

    private void transferIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    private void showState() {
        System.out.println("InputStack: " + inputStack);
        System.out.println("OutputStack: " + outputStack);
        LinkedList<T> logicalQueue = new LinkedList<>();
        for (int i = outputStack.size() - 1; i >= 0; i--) {
            logicalQueue.add(outputStack.get(i));
        }
        for (int i = 0; i < inputStack.size(); i++) {
            logicalQueue.add(inputStack.get(i));
        }
        System.out.println("Logical Queue: " + logicalQueue);
        System.out.println("---------------------------");
    }









}
