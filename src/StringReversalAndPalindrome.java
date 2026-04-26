// Step 1: Create a new Java class
import java.util.Stack; // Step 2: Import Stack class
import java.util.Scanner;

public class StringReversalAndPalindrome {

    public static void main(String[] args) {
        // Step 4: Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Step 5: Create at least 6 different strings to test
        String[] testStrings = {
                "madam",          // palindrome
                "racecar",        // palindrome
                "hello",          // not palindrome
                "A man a plan a canal Panama", // palindrome phrase
                "",               // empty string
                "a"               // single character
        };

        // Step 8: Display results for each test string
        for (String s : testStrings) {
            System.out.println("Original String: " + s);
            String reversed = reverseString(s, stack);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Is Palindrome? " + isPalindrome(s));
            System.out.println("-----------------------------------");
        }

        // Step 9: Show stack contents during reversal process for one example
        System.out.println("Stack contents during reversal of 'hello':");
        reverseString("hello", stack);
    }

    // Step 6: Implement reverseString method
    public static String reverseString(String input, Stack<Character> stack) {
        if (input == null) {
            return "null string";
        }
        stack.clear(); // clear stack before use
        StringBuilder reversed = new StringBuilder();

        // Push each character onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
            System.out.println("Pushed: " + c + " | Stack: " + stack);
        }

        // Pop characters from stack to build reversed string
        while (!stack.isEmpty()) {
            char c = stack.pop();
            reversed.append(c);
            System.out.println("Popped: " + c + " | Stack: " + stack);
        }

        return reversed.toString();
    }

    // Step 7: Implement isPalindrome method
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        if (input.length() <= 1) return true;

        // Normalize string: ignore case and spaces
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return normalized.equals(reversed.toString());
    }

    // Step 11: Bonus method for palindrome phrases (ignoring spaces and punctuation)
    public static boolean isPalindromePhrase(String input) {
        if (input == null) return false;
        if (input.length() <= 1) return true;

        // Remove spaces and punctuation, ignore case
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return normalized.equals(reversed.toString());
    }
}

