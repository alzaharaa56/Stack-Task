import java.util.Stack;

public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();

        history.push("google.com");
        history.push("github.com");
        history.push("stackoverflow.com");
        history.push("oracle.com");

        System.out.println("History: " + history);
        if (!history.empty()) {
            System.out.println("Top site: " + history.peek());
        }

        Stack<String> tempStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int size = history.size();
        for (int i = 0; i < size; i++) {
            tempStack.push(history.pop());
        }
        int tempSize = tempStack.size();
        for (int i = 0; i < tempSize; i++) {
            String url = tempStack.pop();
            sb.append(url);
            if (!tempStack.empty()) {
                sb.append(" -> ");
            }
            history.push(url);
        }

        System.out.println("Formatted: " + sb.toString());

        if (!history.empty()) {
            history.pop();
        }

        System.out.println("After Pop: " + history);

        history.clear();
        System.out.println("Is empty after clear: " + history.empty());
    }
}
