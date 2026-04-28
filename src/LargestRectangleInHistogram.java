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

    }
}

