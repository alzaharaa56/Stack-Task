import java.util.Stack;


public class InfixExpressionEvaluator {

    public static void main(String[] args) {
        String[] expressions = {
                "3 + 5",
                "10 + 2 * 6",
                "100 * (2 + 12)",
                "100 * (2 + 12) / 14",
                "3 + 4 * 2 / (1 - 5) ^ 2 ^ 3",
                "5 % 2",
                "12.5 + 7.3",
                "(10 + 20) * 30",
                "50 / (5 * (2 + 3))",
                "2 ^ 3 ^ 2",
                "-5 + 3",
                "10 / 0"
        };
        for (String expr : expressions) {
            System.out.println("\nExpression: " + expr);
            try {
                double result = evaluate(expr);
                System.out.println("Result = " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static double evaluate(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }

            if (isNumber(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (isNumber(expression.charAt(i)))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                double num = Double.parseDouble(sb.toString());
                operandStack.push(num);
                printStacks(operandStack, operatorStack, "Pushed number " + num);
                continue;
            }

}
