
//03/09/2025
//plz solve again with proper concept
import java.util.*;

public class FindNumberOfWaysToPlacePeopleII {

  // Core function
  public static int numberOfPairs(int[][] points) {
    int n = points.length;
    int ans = 0;

    // Sort by x ascending, y descending
    Arrays.sort(points, Comparator
        .comparingInt((int[] p) -> p[0])
        .thenComparingInt((int[] p) -> -p[1]));

    for (int i = 0; i < n; i++) {
      int maxY = Integer.MIN_VALUE;
      for (int j = i + 1; j < n; j++) {
        if (points[j][1] <= points[i][1] && points[j][1] > maxY) {
          ans++;
          maxY = points[j][1];
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // Example test cases
    int[][] points1 = { { 1, 1 }, { 2, 0 }, { 2, 2 }, { 3, 1 } };
    int[][] points2 = { { 0, 0 }, { 1, 2 }, { 2, 1 }, { 3, 3 } };

    System.out.println("Output 1: " + numberOfPairs(points1)); // expected: 3
    System.out.println("Output 2: " + numberOfPairs(points2)); // expected: 2
  }
}
