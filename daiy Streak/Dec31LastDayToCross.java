import java.util.*;

public class Dec31LastDayToCross {

  // Directions: down, right, up, left
  int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public int latestDayToCross(int row, int col, int[][] cells) {

    int left = 0; // day 0
    int right = cells.length; // last possible day

    while (left < right) {
      int mid = right - (right - left) / 2;

      if (walkPossible(row, col, cells, mid)) {
        left = mid; // crossing possible → go right
      } else {
        right = mid - 1; // crossing not possible → go left
      }
    }

    return left;
  }

  boolean walkPossible(int rows, int cols, int[][] cells, int day) {

    // 0 = land, 1 = water, -1 = visited
    int[][] grid = new int[rows][cols];

    // Flood cells till given day
    for (int i = 0; i < day; i++) {
      int r = cells[i][0] - 1;
      int c = cells[i][1] - 1;
      grid[r][c] = 1;
    }

    Queue<int[]> q = new LinkedList<>();

    // Start BFS from first row
    for (int j = 0; j < cols; j++) {
      if (grid[0][j] == 0) {
        q.offer(new int[] { 0, j });
        grid[0][j] = -1;
      }
    }

    // BFS
    while (!q.isEmpty()) {
      int[] cell = q.poll();

      // Reached bottom row
      if (cell[0] == rows - 1) {
        return true;
      }

      for (int[] d : dirs) {
        int nr = cell[0] + d[0];
        int nc = cell[1] + d[1];

        if (nr >= 0 && nc >= 0 &&
            nr < rows && nc < cols &&
            grid[nr][nc] == 0) {

          grid[nr][nc] = -1;
          q.offer(new int[] { nr, nc });
        }
      }
    }

    return false;
  }

  // 🔹 MAIN METHOD (INPUT HERE)
  public static void main(String[] args) {

    Dec31LastDayToCross sol = new Dec31LastDayToCross();

    int row = 2;
    int col = 2;

    int[][] cells = {
        { 1, 1 },
        { 2, 1 },
        { 1, 2 },
        { 2, 2 }
    };

    int ans = sol.latestDayToCross(row, col, cells);
    System.out.println(ans); // Output: 2
  }
}
