import java.util.*;

public class Dec30MagicSquare {

  // Check whether 3x3 grid starting at (r, c) is magic
  private static boolean isMagicGrid(int[][] grid, int r, int c) {

    // Check numbers 1 to 9 uniqueness
    Set<Integer> st = new HashSet<>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int num = grid[r + i][c + j];
        if (num < 1 || num > 9 || st.contains(num)) {
          return false;
        }
        st.add(num);
      }
    }

    // Sum of first row
    int SUM = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

    // Check rows & columns
    for (int i = 0; i < 3; i++) {
      if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != SUM)
        return false;

      if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != SUM)
        return false;
    }

    // Check diagonals
    if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != SUM)
      return false;

    if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != SUM)
      return false;

    return true;
  }

  public static int numMagicSquaresInside(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;
    int count = 0;

    for (int i = 0; i <= rows - 3; i++) {
      for (int j = 0; j <= cols - 3; j++) {
        if (isMagicGrid(grid, i, j)) {
          count++;
        }
      }
    }

    return count;
  }

  // 🔹 MAIN METHOD (INPUT HERE)
  public static void main(String[] args) {

    int[][] grid = {
        { 4, 3, 8, 4 },
        { 9, 5, 1, 9 },
        { 2, 7, 6, 2 }
    };

    int result = numMagicSquaresInside(grid);
    System.out.println(result); // Output: 1
  }
}
