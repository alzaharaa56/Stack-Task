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


    public void push1(int value) {
        int min = mainStack1.isEmpty() ? value : Math.min(value, mainStack1.peek().minSoFar);
        mainStack1.push(new Pair(value, min));
        System.out.println("Push1: " + value);
        display1();
    }




}
