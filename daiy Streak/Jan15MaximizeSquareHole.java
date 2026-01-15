import java.util.*;

public class Jan15MaximizeSquareHole {

  // SAME LOGIC (NO CHANGE)
  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

    // 1st Step : Sort the inputs
    Arrays.sort(hBars);
    Arrays.sort(vBars);

    int maxConsecutiveHBars = 1;
    int maxConsecutiveVBars = 1;

    // Longest consecutive horizontal bars
    int currConsecutiveHBars = 1;
    for (int i = 1; i < hBars.length; i++) {
      if (hBars[i] - hBars[i - 1] == 1) {
        currConsecutiveHBars++;
      } else {
        currConsecutiveHBars = 1;
      }
      maxConsecutiveHBars = Math.max(maxConsecutiveHBars, currConsecutiveHBars);
    }

    // Longest consecutive vertical bars
    int currConsecutiveVBars = 1;
    for (int i = 1; i < vBars.length; i++) {
      if (vBars[i] - vBars[i - 1] == 1) {
        currConsecutiveVBars++;
      } else {
        currConsecutiveVBars = 1;
      }
      maxConsecutiveVBars = Math.max(maxConsecutiveVBars, currConsecutiveVBars);
    }

    // Square side length
    int side = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;

    return side * side;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int n = 8, m = 6;
    int[] hBars = { 2, 3, 4 };
    int[] vBars = { 1, 2 };

    Jan15MaximizeSquareHole obj = new Jan15MaximizeSquareHole();
    int ans = obj.maximizeSquareHoleArea(n, m, hBars, vBars);

    System.out.println(ans); // Output: 9
  }
}
