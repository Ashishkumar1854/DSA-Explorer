
// copy phaste so solve again this question, no is 2976
import java.util.*;

public class Jan29MinimumCostToConvertString {

  private static void floydWarshall(long[][] dist,
      char[] original,
      char[] changed,
      int[] cost) {

    // direct transformations
    for (int i = 0; i < original.length; i++) {
      int u = original[i] - 'a';
      int v = changed[i] - 'a';
      dist[u][v] = Math.min(dist[u][v], cost[i]);
    }

    // Floyd–Warshall
    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }
  }

  // SAME LOGIC AS LEETCODE
  public static long minimumCost(String source,
      String target,
      char[] original,
      char[] changed,
      int[] cost) {

    long[][] dist = new long[26][26];
    long INF = (long) 1e18;

    for (int i = 0; i < 26; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }

    floydWarshall(dist, original, changed, cost);

    long ans = 0;

    for (int i = 0; i < source.length(); i++) {
      int s = source.charAt(i) - 'a';
      int t = target.charAt(i) - 'a';

      if (s == t)
        continue;

      if (dist[s][t] >= INF) {
        return -1;
      }

      ans += dist[s][t];
    }

    return ans;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    String source = "abcd";
    String target = "acbe";

    char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
    char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
    int[] cost = { 2, 5, 5, 1, 2, 20 };

    long ans = minimumCost(source, target, original, changed, cost);

    System.out.println(ans); // Expected: 28
  }
}
