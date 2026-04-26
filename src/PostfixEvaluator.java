// Step 1: Create a new Java class
import java.util.Stack; // Step 2: Import Stack class

public class PostfixEvaluator {

    public static void main(String[] args) {
        // Step 5: Create at least 6 different postfix expressions to evaluate
        String[] expressions = {
                "5 6 +",          // 5 + 6 = 11
                "10 2 *",         // 10 * 2 = 20
                "20 5 /",         // 20 / 5 = 4
                "15 7 1 1 + - /", // Complex expression
                "8 3 %",          // 8 % 3 = 2
                "12 3 - 2 *"      // (12 - 3) * 2 = 18
        };

        // Step 11: Compare results with manual calculations
        System.out.printf("%-25s %-15s %-15s%n", "Postfix Expression", "Result", "Manual Check");
        System.out.println("-------------------------------------------------------------");

        for (String expr : expressions) {
            int result = evaluatePostfix(expr);
            System.out.printf("%-25s %-15d %-15s%n", expr, result, "Check manually");
            System.out.println("-------------------------------------------------------------");
        }
    }

    // Step 6: Implement evaluatePostfix method
    public static int evaluatePostfix(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty expression provided.");
        }

        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+"); // split by spaces

        System.out.println("Evaluating: " + expression);

        for (String token : tokens) {
            if (isNumber(token)) {
                // Operand: push onto stack
                int num = Integer.parseInt(token);
                stack.push(num);
                System.out.println("Pushed " + num + " | Stack: " + stack);
            } else {
                // Operator: pop two operands
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands.");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("Division by zero.");
                        result = a / b;
                        break;
                    case "%":
                        if (b == 0) throw new ArithmeticException("Modulo by zero.");
                        result = a % b;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(result);
                System.out.println("Applied " + token + " on " + a + " and " + b + " -> Result: " + result + " | Stack: " + stack);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: leftover operands.");
        }

        return stack.pop();
    }

    // Step 7 & 8: Helper method to check if token is a number
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

