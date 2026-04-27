import java.util.Stack;
import java.util.Arrays;


public class StackSorter {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        System.out.println("Sorting (Iterative): Initial stack " + stack);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println("Popped: " + current);

            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                int moved = tempStack.pop();
                stack.push(moved);
                System.out.println("Moved back: " + moved);
            }
            tempStack.push(current);
            System.out.println("TempStack: " + tempStack + " | MainStack: " + stack);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        System.out.println("Sorted stack (Iterative): " + stack);
    }


    public static void sortStackRecursive(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStackRecursive(stack);
            insertInSortedOrder(stack, top);
        }
    }





        }
    }

}
