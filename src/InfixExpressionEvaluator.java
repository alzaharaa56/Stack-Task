import java.util.Stack;

public class InfixExpressionEvaluator {


    public static void main(String[] args) {
        String[] expressions = {

                "10 + 2 * 6",

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


            if (ch == '(') {
                operatorStack.push(ch);
                printStacks(operandStack, operatorStack, "Pushed '('");
            }


            else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    double b = operandStack.pop();
                    double a = operandStack.pop();
                    char op = operatorStack.pop();
                    operandStack.push(applyOperation(a, b, op));
                    printStacks(operandStack, operatorStack, "Applied operator " + op);
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                    printStacks(operandStack, operatorStack, "Popped '('");
                }
            }


            else if (isOperator(ch)) {

                if (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                    operandStack.push(0.0);
                    printStacks(operandStack, operatorStack, "Handled unary minus");
                }

                while (!operatorStack.isEmpty() &&
                        getPrecedence(operatorStack.peek()) >= getPrecedence(ch)) {
                    double b = operandStack.pop();
                    double a = operandStack.pop();
                    char op = operatorStack.pop();
                    operandStack.push(applyOperation(a, b, op));
                    printStacks(operandStack, operatorStack, "Applied operator " + op);
                }
                operatorStack.push(ch);
                printStacks(operandStack, operatorStack, "Pushed operator " + ch);
            }
            i++;
        }


        while (!operatorStack.isEmpty()) {
            double b = operandStack.pop();
            double a = operandStack.pop();
            char op = operatorStack.pop();
            operandStack.push(applyOperation(a, b, op));
            printStacks(operandStack, operatorStack, "Applied operator " + op);
        }

        return operandStack.pop();
    }


    public static double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case '^': return Math.pow(a, b);
            case '%':
                if (b == 0) throw new ArithmeticException("Modulo by zero");
                return a % b;
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }


    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%': return 2;
            case '^': return 3;
        }
        return -1;
    }


    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%';
    }


    public static boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9') || ch == '.';
    }


    public static void printStacks(Stack<Double> operandStack, Stack<Character> operatorStack, String action) {
        System.out.println(action);
        System.out.println("Operand Stack: " + operandStack);
        System.out.println("Operator Stack: " + operatorStack);
    }
}
