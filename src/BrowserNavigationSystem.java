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
                backStack.remove(0);
            }
            backStack.push(currentPage);
        }

        forwardStack.clear();
        currentPage = url;
        sessionPages.add(url);
        showStatus("Visited: " + url);
    }
    public void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("Cannot go forward, no forward history.");
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        showStatus("Went forward");
    }

    public void showCurrentPage() {
        System.out.println("Current page: " + currentPage);
    }
    public void showHistory() {
        System.out.println("Back stack: " + backStack);
        System.out.println("Forward stack: " + forwardStack);
    }


    public void showSessionPages() {
        System.out.println("Session pages: " + sessionPages);
    }

    private void showStatus(String action) {
        System.out.println("Action: " + action);
        showCurrentPage();
        showHistory();
        System.out.println("---------------------------");
    }




    }


