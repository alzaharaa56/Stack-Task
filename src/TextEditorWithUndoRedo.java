
import java.util.Stack; // Step 2: Import Stack class

public class TextEditorWithUndoRedo {

    // Step 5: StringBuilder to store current text
    private static StringBuilder text = new StringBuilder();

    // Step 4: Two stacks for undo and redo
    private static Stack<String> undoStack = new Stack<>();
    private static Stack<String> redoStack = new Stack<>();

    // Limit for undo history
    private static final int UNDO_LIMIT = 10;

    public static void main(String[] args) {
        // Step 7: Simulate at least 8 user actions
        type("Hello");
        display();

        type(" World");
        display();

        undo();
        display();

        redo();
        display();

        type("!");
        display();

        undo();
        display();

        undo();
        display();

        redo();
        display();
    }

    // Step 6: type method - add new text
    public static void type(String newText) {
        // Save current state to undo stack
        if (undoStack.size() == UNDO_LIMIT) {
            undoStack.remove(0); // remove oldest if limit exceeded
        }
        undoStack.push(text.toString());


        redoStack.clear();

        // Append new text
        text.append(newText);
        System.out.println("Typed: \"" + newText + "\"");
    }

    // Step 6: undo method
    public static void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        // Save current state to redo stack
        redoStack.push(text.toString());

        // Restore last state from undo stack
        text = new StringBuilder(undoStack.pop());
        System.out.println("Undo performed.");
    }

    // Step 6: redo method
    public static void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        // Save current state to undo stack
        if (undoStack.size() == UNDO_LIMIT) {
            undoStack.remove(0);
        }
        undoStack.push(text.toString());

        // Restore last state from redo stack
        text = new StringBuilder(redoStack.pop());
        System.out.println("Redo performed.");
    }

    // Step 6: display method
    public static void display() {
        System.out.println("Current Text: \"" + text + "\"");
        System.out.println("Undo Stack: " + undoStack);
        System.out.println("Redo Stack: " + redoStack);
        System.out.println("-----------------------------------");
    }
}

