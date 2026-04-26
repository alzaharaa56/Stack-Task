// Step 1: Create a new Java class
import java.util.Stack; // Step 2: Import Stack class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagValidator {

    public static void main(String[] args) {
        // Step 5: Create at least 8 different HTML/XML strings to validate
        String[] testCases = {
                "<html><head><title>Test</title></head><body><div><p>Hello</p></div></body></html>", // valid
                "<div><p><b>Bold</b></p></div>", // valid
                "<div><p><b>Bold</p></b></div>", // mismatched
                "<div><img src='image.jpg'/></div>", // valid with self-closing
                "<p>Hello<br/>World</p>", // valid with self-closing
                "<html><body><h1>Title</h1><p>Paragraph</body></html>", // unclosed <p>
                "", // empty string
                "Just plain text without tags" // no tags
        };

        for (String html : testCases) {
            System.out.println("Validating: " + html);
            boolean result = validateHtmlTags(html);
            System.out.println("Result: " + (result ? "Valid" : "Invalid"));
            System.out.println("------------------------");
        }
    }

    // Step 6: Implement validateHtmlTags method
    public static boolean validateHtmlTags(String html) {
        if (html == null || html.trim().isEmpty()) {
            System.out.println("Error: Empty string provided.");
            return false;
        }

        Stack<String> stack = new Stack<>();

        // Regex to extract tags (handles attributes and self-closing)
        Pattern tagPattern = Pattern.compile("<(/?[^>]+)>");
        Matcher matcher = tagPattern.matcher(html);

        while (matcher.find()) {
            String tagContent = matcher.group(1).trim();

            // Handle self-closing tags
            if (tagContent.endsWith("/")) {
                System.out.println("Self-closing tag detected: <" + tagContent + ">");
                continue;
            }

            // Handle closing tags
            if (tagContent.startsWith("/")) {
                String closingTag = tagContent.substring(1).split("\\s+")[0];
                if (stack.isEmpty()) {
                    System.out.println("Error: Closing tag </" + closingTag + "> found but stack is empty.");
                    return false;
                }
                String lastOpened = stack.pop();
                if (!lastOpened.equals(closingTag)) {
                    System.out.println("Error: Mismatched tag. Expected </" + lastOpened + "> but found </" + closingTag + ">.");
                    return false;
                }
                System.out.println("Closed tag </" + closingTag + "> | Stack: " + stack);
            } else {
                // Opening tag (ignore attributes)
                String openingTag = tagContent.split("\\s+")[0];
                stack.push(openingTag);
                System.out.println("Opened tag <" + openingTag + "> | Stack: " + stack);
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: Unclosed tags remain in stack: " + stack);
            return false;
        }

        return true;
    }
}

