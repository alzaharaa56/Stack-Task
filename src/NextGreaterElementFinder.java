import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementFinder {


    public static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Step-by-step Next Greater (linear):");
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                result[idx] = arr[i];
                System.out.println("Element " + arr[idx] + " at index " + idx +
                        " → Next Greater: " + arr[i]);
            }
            stack.push(i);
            System.out.println("Token: " + arr[i] + " | Stack indices: " + stack);
        }
        return result;
    }

    public static int[] findNextGreaterElementCircular(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Finding Next Greater Element (circular):");
        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];
            while (!stack.isEmpty() && num > arr[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = num;
                System.out.println("Element " + arr[idx] + " → Next Greater (circular): " + num);
            }
            if (i < n) stack.push(i);
        }
        return result;
    }

    public static int[] findNextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Finding Next Smaller Element:");
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = arr[i];
                System.out.println("Element " + arr[idx] + " → Next Smaller: " + arr[i]);
            }
            stack.push(i);
            System.out.println("Token: " + arr[i] + " | Stack indices: " + stack);
        }
        return result;
    }
    public static void displayResults(int[] arr, int[] result, String label) {
        System.out.println("\n" + label);
        System.out.println("Index | Value | Result");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d | %5d | %6d%n", i, arr[i], result[i]);
        }
    }





    }
}