
public class Jan13SeparateSquares {

  // SAME LOGIC (NO CHANGE)
  private boolean check(int[][] squares, double midY, double total) {
    double bottomArea = 0.0;

    for (int[] square : squares) {
      double y = square[1];
      double l = square[2];

      double bottomY = y;
      double topY = y + l;

      if (midY >= topY) {
        // full square below
        bottomArea += l * l;
      } else if (midY > bottomY) {
        // partial square below
        bottomArea += (midY - bottomY) * l;
      }
    }

    return bottomArea >= total / 2.0;
  }

  public double separateSquares(int[][] squares) {
    double low = Double.MAX_VALUE;
    double high = -Double.MAX_VALUE;
    double total = 0.0;

    for (int[] square : squares) {
      double y = square[1];
      double l = square[2];

      total += l * l;
      low = Math.min(low, y);
      high = Math.max(high, y + l);
    }

    double resultY = 0.0;

    while (high - low > 1e-5) {
      double midY = low + (high - low) / 2.0;
      resultY = midY;

      if (check(squares, midY, total)) {
        high = midY;
      } else {
        low = midY;
      }
    }

    return resultY;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[][] squares = {
        { 0, 0, 2 },
        { 1, 1, 1 }
    };

    Jan13SeparateSquares obj = new Jan13SeparateSquares();
    double ans = obj.separateSquares(squares);

    System.out.printf("%.5f%n", ans); // Output: 1.16667
  }
}
