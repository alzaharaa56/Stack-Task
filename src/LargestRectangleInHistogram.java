import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[][] histograms = {
                {2, 1, 5, 6, 2, 3},
                {2, 4},

        };

        for (int[] heights : histograms) {
            System.out.println("\nHistogram: ");
            displayHistogram(heights);

            int maxAreaStack = findLargestRectangle(heights);
            int maxAreaBrute = bruteForceLargestRectangle(heights);

            displayResult(heights, maxAreaStack, maxAreaBrute);
        }


        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println("\nBinary Matrix Largest Rectangle: " + maximalRectangle(matrix));
    }


    public static int findLargestRectangle(int[] heights) {
        if (heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);

                System.out.println("Popped height=" + height + ", width=" + width + ", area=" + area);
                System.out.println("Stack after pop: " + stack);
            }
            stack.push(i);
            System.out.println("Pushed index " + i + " (height=" + h + ")");
            System.out.println("Stack: " + stack);
        }
        return maxArea;
    }


    public static int bruteForceLargestRectangle(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }


    public static int calculateArea(int[] heights, int start, int end, int height) {
        return height * (end - start + 1);
    }


    public static void displayHistogram(int[] heights) {
        if (heights.length == 0) {
            System.out.println("(empty histogram)");
            return;
        }
        int max = 0;
        for (int h : heights) max = Math.max(max, h);

        for (int level = max; level >= 1; level--) {
            for (int h : heights) {
                if (h >= level) System.out.print("|#| ");
                else System.out.print("    ");
            }
            System.out.println();
        }
        for (int h : heights) {
            System.out.printf("%3d ", h);
        }
        System.out.println();
    }


    public static void displayResult(int[] heights, int maxAreaStack, int maxAreaBrute) {
        System.out.println("Max Area (Stack O(n)) = " + maxAreaStack);
        System.out.println("Max Area (Brute O(n^2)) = " + maxAreaBrute);
    }


    public static int maximalRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = row[j] == 0 ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, findLargestRectangle(heights));
        }
        return maxArea;
    }
}
