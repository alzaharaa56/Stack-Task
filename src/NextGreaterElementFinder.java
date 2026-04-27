import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementFinder {


    public static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Finding Next Greater Element (linear):");
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = arr[i];
                System.out.println("Element " + arr[idx] + " → Next Greater: " + arr[i]);
            }
            stack.push(i);
            System.out.println("Token: " + arr[i] + " | Stack indices: " + stack);
        }
        return result;
    }
    }
}