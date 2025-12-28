
public class Dec28 {

  public static void main(String[] args) {

    int[][] grid = {
        { 4, 3, 2, -1 },
        { 3, 2, 1, -1 },
        { 1, 1, -1, -2 },
        { -1, -1, -2, -3 }
    };

    int result = countNegatives(grid);
    System.out.println("Negative numbers count: " + result);
  }

  // LeetCode logic
  public static int countNegatives(int[][] grid) {
    int count = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
      int left = 0, right = cols - 1;
      int firstNeg = cols;

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (grid[i][mid] < 0) {
          firstNeg = mid;
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      count += (cols - firstNeg);
    }
    return count;
  }
}
