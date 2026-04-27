import java.util.Stack;


public class InfixExpressionEvaluator {

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '^': return 3;
            case '*': case '/': case '%': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }



}
