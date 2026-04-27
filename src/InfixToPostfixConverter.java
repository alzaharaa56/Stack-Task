
import java.util.*;


public class InfixToPostfixConverter {

    public static String infixToPostfix(String infix)
    {


        StringBuilder postfix = new StringBuilder();


        Stack<Character> stk = new Stack<>();
        for (char c : infix.toCharArray()) {


            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);


            }
            else if (c == '(') {
                stk.push(c);


            }
            else if (c == ')') {
                while (!stk.isEmpty()
                        && stk.peek() != '(') {
                    postfix.append(stk.pop());
                }
                stk.pop();

            }
            else {


                while (!stk.isEmpty()
                        && precedence(stk.peek())
                        >= precedence(c)) {
                    postfix.append(stk.pop());
                }
                stk.push(c);

            }
        }


        while (!stk.isEmpty()) {
            postfix.append(stk.pop());
        }

        return postfix.toString();
    }


    public static int precedence(char operator)
    {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // main function
    public static void main(String[] args)
    {
        System.out.println("Enter a Infix expression:");
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();

        sc.close();
        String postfix = infixToPostfix(infix);

        System.out.println("Postfix Expression: \n"
                + postfix);
    }
}