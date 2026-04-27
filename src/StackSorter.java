import java.util.Stack;
import java.util.Arrays;


public class StackSorter {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        System.out.println("Sorting (Iterative): Initial stack " + stack);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println("Popped: " + current);
        }
    }

}
