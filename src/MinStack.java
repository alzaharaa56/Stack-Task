import java.util.Stack;

public class MinStack {
    private static class Pair {
        int value;
        int minSoFar;
        Pair(int value, int minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }
        public String toString() {
            return "(" + value + ", min=" + minSoFar + ")";
        }
    }

    private Stack<Pair> mainStack1 = new Stack<>();

    private Stack<Integer> mainStack2 = new Stack<>();
    private Stack<Integer> minStack2 = new Stack<>();







}
