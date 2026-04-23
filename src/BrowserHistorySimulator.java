import java.util.Stack;

public class BrowserHistorySimulator {




        public static void main(String[] args) {

            Stack<String> history = new Stack<>();


            history.push("http://google.com/");
            displayHistory(history);

            history.push("http://github.com/");
            displayHistory(history);

            history.push("http://oracle.com/");
            displayHistory(history);

            history.push("https://example.com/contact");
            displayHistory(history);

            history.push("https://example.com/blog");
            displayHistory(history);


            System.out.println("Pressing Back Button ");
            history.pop();
            System.out.println("Current page after 1st back: " + history.peek());

            history.pop();
            System.out.println("Current page after 2nd back: " + history.peek());


            System.out.println("Peek current page: " + history.peek());


            System.out.println("Is history empty? " + history.isEmpty());


            history.push("https://example.com/news");
            displayHistory(history);

            history.push("https://example.com/gallery");
            displayHistory(history);


            System.out.println(" Final Browsing History ");
            for (String page : history) {
                System.out.println(page);
            }
        }


        private static void displayHistory(Stack<String> history) {
            System.out.println("Visited: " + history.peek());
            System.out.println("Browsing History: " + history);
        }
    }

