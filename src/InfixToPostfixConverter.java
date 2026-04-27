
import java.util.Stack;

public class InfixToPostfixConverter {

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '^': return 3;
            case '*': case '/': case '%': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }


    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
    }

    private static double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case '%': return a % b;
            case '^': return Math.pow(a, b);
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }



}
