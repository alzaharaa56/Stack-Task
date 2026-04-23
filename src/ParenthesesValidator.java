
import java.util.Stack;

public class ParenthesesValidator {
    public static void main(String[] args) {
        String[] testStrings = {"{[()]}", "(()", "[(])", "{[]}", ""};

        for (String expression : testStrings) {
            System.out.println("Testing: " + expression);
            boolean result = isBalanced(expression);
            System.out.println("Final Result: " + (result ? "Balanced" : "Not Balanced"));

        }
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        if (expression.isEmpty())
            return true;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();
                if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            System.out.println("Stack: " + stack);
        }

        boolean balanced = stack.isEmpty();
        stack.clear();
        return balanced;
    }
}