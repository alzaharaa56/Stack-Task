import java.util.Stack;

public class BrowserNavigationSystem {

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage = null;

    private LinkedList<String> sessionPages = new LinkedList<>();

    private final int MAX_HISTORY = 10;

    public void visitPage(String url) {
        if (currentPage != null) {
            if (backStack.size() >= MAX_HISTORY) {

}


