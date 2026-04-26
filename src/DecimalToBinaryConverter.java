// Step 1: Create a new Java class
import java.util.Stack; // Step 2: Import Stack class
import java.util.Arrays;

public class DecimalToBinaryConverter {

    public static void main(String[] args) {
        // Step 5: Create at least 6 different decimal numbers to convert
        int[] testNumbers = {0, 1, 5, 10, 255, -42};

        // Step 10: Display all conversions in a formatted table
        System.out.printf("%-10s %-20s %-20s %-20s%n",
                "Decimal", "Binary (Stack)", "Binary (Built-in)", "Match?");
        System.out.println("----------------");

        for (int num : testNumbers) {
            String binaryStack = decimalToBinary(num);
            String binaryBuiltIn = (num >= 0) ? Integer.toBinaryString(num) : "-" + Integer.toBinaryString(-num);
            boolean match = binaryStack.equals(binaryBuiltIn);

            System.out.printf("%-10d %-20s %-20s %-20s%n",
                    num, binaryStack, binaryBuiltIn, match ? "Yes" : "No");

            // Step 7: Show conversion process for each number
            displayConversionProcess(num);
            System.out.println("------------------");
        }

        // Step 9: Bonus method - convert binary back to decimal
        String binaryExample = "1010"; // binary for 10
        int decimalResult = binaryToDecimal(binaryExample);
        System.out.println("Bonus: Binary " + binaryExample + " back to Decimal = " + decimalResult);
    }

    // Step 6: Implement decimalToBinary method
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        if (decimal < 0) {
            // Handle negative numbers by converting absolute value and prefixing "-"
            return "-" + decimalToBinary(-decimal);
        }

        Stack<Integer> stack = new Stack<>();
        int num = decimal;

        // Perform division by 2 and push remainders
        while (num > 0) {
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
        }

        // Pop from stack to build binary string
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    // Step 7: Implement displayConversionProcess method
    public static void displayConversionProcess(int decimal) {
        if (decimal == 0) {
            System.out.println("Decimal 0 -> Binary 0");
            return;
        }
        if (decimal < 0) {
            System.out.println("Handling negative number: " + decimal);
            decimal = -decimal;
        }

        Stack<Integer> stack = new Stack<>();
        int num = decimal;

        System.out.println("Conversion process for " + decimal + ":");
        while (num > 0) {
            int remainder = num % 2;
            int quotient = num / 2;
            stack.push(remainder);
            System.out.println("Quotient: " + quotient + ", Remainder: " + remainder + ", Stack: " + stack);
            num = quotient;
        }
    }

    // Step 9: Bonus method - convert binary back to decimal
    public static int binaryToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) return 0;

        boolean isNegative = binary.startsWith("-");
        if (isNegative) binary = binary.substring(1);

        int decimal = 0;
        for (char c : binary.toCharArray()) {
            decimal = decimal * 2 + (c - '0');
        }

        return isNegative ? -decimal : decimal;
    }
}

