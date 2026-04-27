import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingTwoStacks<T> {
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


    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();


        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.enqueue(40);
        queue.peek();
        queue.enqueue(50);
        queue.dequeue();
        queue.enqueue(60);
        queue.dequeue();
        queue.peek();
        queue.dequeue();


        Queue<Integer> builtInQueue = new LinkedList<>();
        builtInQueue.add(10);
        builtInQueue.add(20);
        builtInQueue.add(30);
        System.out.println("\nBuilt-in Queue: " + builtInQueue);
        builtInQueue.poll();
        System.out.println("After poll: " + builtInQueue);
    }
}
