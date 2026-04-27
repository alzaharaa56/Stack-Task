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


    public void pop1() {
        if (mainStack1.isEmpty()) {
            System.out.println("Stack1 empty, cannot pop.");
            return;
        }
        Pair p = mainStack1.pop();
        System.out.println("Pop1: " + p.value);
        display1();
    }


    public void peek1() {
        if (mainStack1.isEmpty()) {
            System.out.println("Stack1 empty, cannot peek.");
            return;
        }
        System.out.println("Peek1: " + mainStack1.peek().value);
        display1();
    }


    public void getMin1() {
        if (mainStack1.isEmpty()) {
            System.out.println("Stack1 empty, no min.");
            return;
        }
        System.out.println("Min1: " + mainStack1.peek().minSoFar);
    }


    public void display1() {
        System.out.println("MainStack1: " + mainStack1);
    }


    public void push2(int value) {
        mainStack2.push(value);
        if (minStack2.isEmpty() || value <= minStack2.peek()) {
            minStack2.push(value);
        }
        System.out.println("Push2: " + value);
        display2();
    }


    public void pop2() {
        if (mainStack2.isEmpty()) {
            System.out.println("Stack2 empty, cannot pop.");
            return;
        }
        int val = mainStack2.pop();
        if (!minStack2.isEmpty() && val == minStack2.peek()) {
            minStack2.pop();
        }
        System.out.println("Pop2: " + val);
        display2();
    }


    public void peek2() {
        if (mainStack2.isEmpty()) {
            System.out.println("Stack2 empty, cannot peek.");
            return;
        }
        System.out.println("Peek2: " + mainStack2.peek());
        display2();
    }


    public void getMin2() {
        if (minStack2.isEmpty()) {
            System.out.println("Stack2 empty, no min.");
            return;
        }
        System.out.println("Min2: " + minStack2.peek());
    }


    public void display2() {
        System.out.println("MainStack2: " + mainStack2);
        System.out.println("MinStack2: " + minStack2);
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();


        ms.push1(5); ms.push2(5);
        ms.push1(3); ms.push2(3);
        ms.push1(7); ms.push2(7);
        ms.getMin1(); ms.getMin2();
        ms.pop1(); ms.pop2();
        ms.getMin1(); ms.getMin2();
        ms.push1(2); ms.push2(2);
        ms.push1(8); ms.push2(8);
        ms.peek1(); ms.peek2();
        ms.getMin1(); ms.getMin2();
        ms.pop1(); ms.pop2();
        ms.pop1(); ms.pop2();
        ms.getMin1(); ms.getMin2();
        ms.pop1(); ms.pop2();
        ms.pop1(); ms.pop2();
        ms.getMin1(); ms.getMin2();
    }
}
