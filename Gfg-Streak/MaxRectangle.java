
// solve again after study 2d array .21sep 2025
import java.util.*;

public class MaxRectangle {

  // Main method
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Example input
    // 4 4
    // 0 1 1 0
    // 1 1 1 1
    // 1 1 1 1
    // 1 1 0 0

    int n = sc.nextInt(); // rows
    int m = sc.nextInt(); // cols
    int[][] mat = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = sc.nextInt();
      }
    }

    System.out.println(maxArea(mat));
    sc.close();
  }

  // Function to calculate max rectangle area
  static int maxArea(int mat[][]) {
    int n = mat.length;
    int m = mat[0].length;
    int[] height = new int[m];
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      // Update histogram heights
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          height[j] = 0;
        } else {
          height[j] += 1;
        }
      }
      // Compute max area for current histogram
      maxArea = Math.max(maxArea, largestRectangleArea(height));
    }

    return maxArea;
  }

  // Helper: Largest Rectangle in Histogram
  private static int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
      int h = (i == n ? 0 : heights[i]);
      while (!stack.isEmpty() && h < heights[stack.peek()]) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }
      stack.push(i);
    }

    return maxArea;
  }
}
