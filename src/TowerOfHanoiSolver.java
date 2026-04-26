// Step 1: Create a new Java class
import java.util.Stack; // Step 2: Import Stack class

public class TowerOfHanoiSolver {

    // Step 4: Create three Stacks to represent pegs A, B, C
    private static Stack<Integer> pegA = new Stack<>();
    private static Stack<Integer> pegB = new Stack<>();
    private static Stack<Integer> pegC = new Stack<>();

    private static int moveCount = 0; // Step 9: Count total moves

    public static void main(String[] args) {
        // Step 6: Solve Tower of Hanoi for 3, 4, and 5 disks
        solveAndDisplay(3);
        solveAndDisplay(4);
        solveAndDisplay(5);
    }

    // Helper method to run solver for given number of disks
    private static void solveAndDisplay(int numDisks) {
        System.out.println("=== Solving Tower of Hanoi for " + numDisks + " disks ===");
        initializePegs(numDisks);
        displayPegs();

        moveCount = 0;
        solveHanoi(numDisks, 'A', 'C', 'B');

        int theoreticalMoves = (int) Math.pow(2, numDisks) - 1;
        System.out.println("Total moves made: " + moveCount);
        System.out.println("Theoretical minimum moves: " + theoreticalMoves);
        System.out.println("---------------------------------------------------\n");
    }

    // Step 5: initializePegs method
    public static void initializePegs(int numDisks) {
        pegA.clear();
        pegB.clear();
        pegC.clear();

        // Largest disk at bottom (highest number)
        for (int i = numDisks; i >= 1; i--) {
            pegA.push(i);
        }
    }

    // Step 5: moveDisk method
    public static void moveDisk(char fromPeg, char toPeg) {
        Stack<Integer> source = getPeg(fromPeg);
        Stack<Integer> destination = getPeg(toPeg);

        if (!isValidMove(fromPeg, toPeg)) {
            System.out.println("Illegal move attempted from " + fromPeg + " to " + toPeg);
            return;
        }

        int disk = source.pop();
        destination.push(disk);
        moveCount++;

        System.out.println("Move disk " + disk + " from " + fromPeg + " to " + toPeg);
        displayPegs();
    }

    // Step 5: isValidMove method
    public static boolean isValidMove(char fromPeg, char toPeg) {
        Stack<Integer> source = getPeg(fromPeg);
        Stack<Integer> destination = getPeg(toPeg);

        if (source.isEmpty()) return false;
        if (destination.isEmpty()) return true;

        // Larger disk cannot be placed on smaller disk
        return source.peek() < destination.peek();
    }

    // Step 5: solveHanoi method (recursive solution)
    public static void solveHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            moveDisk(from, to);
            return;
        }
        solveHanoi(n - 1, from, aux, to);
        moveDisk(from, to);
        solveHanoi(n - 1, aux, to, from);
    }

    // Step 5: displayPegs method
    public static void displayPegs() {
        System.out.println("Peg A: " + pegA);
        System.out.println("Peg B: " + pegB);
        System.out.println("Peg C: " + pegC);
        System.out.println("-----------------------------------");
    }

    // Helper method to get peg by char
    private static Stack<Integer> getPeg(char pegName) {
        switch (pegName) {
            case 'A': return pegA;
            case 'B': return pegB;
            case 'C': return pegC;
            default: throw new IllegalArgumentException("Invalid peg name: " + pegName);
        }
    }
}

