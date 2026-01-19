
//solve again after ern concept

public class Jan19MaxSideLengthSquare {

  // SAME LOGIC (NO CHANGE)
  public int maxSideLength(int[][] mat, int threshold) {
    int rows = mat.length;
    int cols = mat[0].length;

    int[][] prefix = new int[rows][cols];

    // Build prefix sum
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        prefix[i][j] = mat[i][j]
            + (i > 0 ? prefix[i - 1][j] : 0)
            + (j > 0 ? prefix[i][j - 1] : 0)
            - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
      }
    }

    int best = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        for (int k = best; k < Math.min(rows - i, cols - j); k++) {

          int r2 = i + k;
          int c2 = j + k;

          int sum = prefix[r2][c2];
          if (i > 0)
            sum -= prefix[i - 1][c2];
          if (j > 0)
            sum -= prefix[r2][j - 1];
          if (i > 0 && j > 0)
            sum += prefix[i - 1][j - 1];

          if (sum <= threshold) {
            best = k + 1;
          } else {
            break;
          }
        }
      }
    }

    return best;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[][] mat = {
        { 1, 1, 3, 2, 4, 3, 2 },
        { 1, 1, 3, 2, 4, 3, 2 },
        { 1, 1, 3, 2, 4, 3, 2 }
    };
    int threshold = 4;

    Jan19MaxSideLengthSquare obj = new Jan19MaxSideLengthSquare();
    int ans = obj.maxSideLength(mat, threshold);

    System.out.println(ans); // Output: 2
  }
}
