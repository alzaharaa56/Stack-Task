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


    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int top = stack.pop();
            insertInSortedOrder(stack, value);
            stack.push(top);
        }
    }

    public static void displayStack(Stack<Integer> stack, String name) {
        System.out.println(name + ": " + stack);
    }

    public static void main(String[] args) {

        Stack<Integer>[] testStacks = new Stack[5];

        testStacks[0] = new Stack<>();
        testStacks[0].addAll(Arrays.asList(3, 1, 4, 2, 5));

        testStacks[1] = new Stack<>();
        testStacks[1].addAll(Arrays.asList(10, 9, 8, 7, 6, 5));

        testStacks[2] = new Stack<>();
        testStacks[2].addAll(Arrays.asList(1, 2, 3, 4, 5));

        testStacks[3] = new Stack<>();
        testStacks[3].addAll(Arrays.asList(15));

        testStacks[4] = new Stack<>();

        for (int i = 0; i < testStacks.length; i++) {
            System.out.println("\n--- Stack " + (i+1) + " ---");
            displayStack(testStacks[i], "Original");


            sortStack((Stack<Integer>) testStacks[i].clone());


            Stack<Integer> recursiveStack = (Stack<Integer>) testStacks[i].clone();
            sortStackRecursive(recursiveStack);
            displayStack(recursiveStack, "Sorted (Recursive)");
        }


        System.out.println("\nComplexity Analysis:");
        System.out.println("Iterative: O(n^2) worst case due to repeated moves.");
        System.out.println("Recursive: O(n^2) worst case, but elegant.");
        System.out.println("Space: O(n) for temporary stack or recursion call stack.");
    }







}
