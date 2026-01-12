import java.util.*;

public class Jan11MaximalRectangle {

  // SAME CODE (NO LOGIC CHANGE)

  public int[] NSR(int[] heights) {
    Stack<Integer> st = new Stack<>();
    int n = heights.length;
    int pseudo_index = n;
    int[] right = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      while (!st.empty() && heights[st.peek()] >= heights[i]) {
        st.pop();
      }
      right[i] = st.empty() ? pseudo_index : st.peek();
      st.push(i);
    }
    return right;
  }

  public int[] NSL(int[] heights) {
    Stack<Integer> st = new Stack<>();
    int n = heights.length;
    int pseudo_index = -1;
    int[] left = new int[n];

    for (int i = 0; i < n; i++) {
      while (!st.empty() && heights[st.peek()] >= heights[i]) {
        st.pop();
      }
      left[i] = st.empty() ? pseudo_index : st.peek();
      st.push(i);
    }
    return left;
  }

  public int MAH(int[] heights) {
    int n = heights.length;
    int[] right = NSR(heights);
    int[] left = NSL(heights);

    int max_area = 0;
    for (int i = 0; i < n; i++) {
      int width = right[i] - left[i] - 1;
      int area = width * heights[i];
      max_area = Math.max(max_area, area);
    }
    return max_area;
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int n = matrix.length;
    int m = matrix[0].length;
    int[] height = new int[m];

    // first row
    for (int j = 0; j < m; j++) {
      height[j] = (matrix[0][j] == '1') ? 1 : 0;
    }

    int maxA = MAH(height);

    // remaining rows
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0')
          height[j] = 0;
        else
          height[j] += 1;
      }
      maxA = Math.max(maxA, MAH(height));
    }

    return maxA;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    char[][] matrix = {
        { '1', '0', '1', '0', '0' },
        { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' }
    };

    Jan11MaximalRectangle obj = new Jan11MaximalRectangle();
    int ans = obj.maximalRectangle(matrix);

    System.out.println(ans); // Output: 6
  }
}
