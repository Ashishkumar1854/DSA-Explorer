
//sovlve again hard level question 2977
import java.util.*;

public class Jan30MinimumCostToConvertStringII {

  static class Pair {
    long cost;
    String node;

    Pair(long cost, String node) {
      this.cost = cost;
      this.node = node;
    }
  }

  long BIG_VALUE = (long) 1e10;

  Map<String, List<Pair>> adj = new HashMap<>();
  Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();

  long[] dpMemo;
  String sourceStr, targetStr;
  TreeSet<Integer> validLengths = new TreeSet<>();

  // ---------- DIJKSTRA ----------
  long dijkstra(String start, String end) {

    if (dijkstraMemo.containsKey(start) &&
        dijkstraMemo.get(start).containsKey(end)) {
      return dijkstraMemo.get(start).get(end);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));

    Map<String, Long> dist = new HashMap<>();
    dist.put(start, 0L);
    pq.offer(new Pair(0, start));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (curr.node.equals(end))
        break;

      if (!adj.containsKey(curr.node))
        continue;

      for (Pair edge : adj.get(curr.node)) {
        long newCost = curr.cost + edge.cost;

        if (!dist.containsKey(edge.node) ||
            newCost < dist.get(edge.node)) {

          dist.put(edge.node, newCost);
          pq.offer(new Pair(newCost, edge.node));
        }
      }
    }

    long ans = dist.getOrDefault(end, BIG_VALUE);

    dijkstraMemo
        .computeIfAbsent(start, k -> new HashMap<>())
        .put(end, ans);

    return ans;
  }

  // ---------- DP ----------
  long solve(int idx) {

    if (idx == sourceStr.length())
      return 0;

    if (dpMemo[idx] != -1)
      return dpMemo[idx];

    long minCost = BIG_VALUE;

    // No operation if chars already same
    if (sourceStr.charAt(idx) == targetStr.charAt(idx)) {
      minCost = solve(idx + 1);
    }

    // Try all valid substring lengths
    for (int len : validLengths) {

      if (idx + len > sourceStr.length())
        break;

      String srcSub = sourceStr.substring(idx, idx + len);
      String tgtSub = targetStr.substring(idx, idx + len);

      if (!adj.containsKey(srcSub))
        continue;

      long cost = dijkstra(srcSub, tgtSub);
      if (cost == BIG_VALUE)
        continue;

      minCost = Math.min(minCost, cost + solve(idx + len));
    }

    return dpMemo[idx] = minCost;
  }

  // ---------- MAIN FUNCTION ----------
  public long minimumCost(
      String source,
      String target,
      String[] original,
      String[] changed,
      int[] cost) {

    sourceStr = source;
    targetStr = target;

    dpMemo = new long[source.length() + 1];
    Arrays.fill(dpMemo, -1);

    for (int i = 0; i < original.length; i++) {
      adj.computeIfAbsent(original[i], k -> new ArrayList<>())
          .add(new Pair(cost[i], changed[i]));
      validLengths.add(original[i].length());
    }

    long res = solve(0);
    return res == BIG_VALUE ? -1 : res;
  }

  // ---------- VS CODE TEST ----------
  public static void main(String[] args) {

    Jan30MinimumCostToConvertStringII sol = new Jan30MinimumCostToConvertStringII();

    String source = "abcd";
    String target = "acbe";

    String[] original = { "a", "b", "c", "c", "e", "d" };
    String[] changed = { "b", "c", "b", "e", "b", "e" };
    int[] cost = { 2, 5, 5, 1, 2, 20 };

    long ans = sol.minimumCost(source, target, original, changed, cost);
    System.out.println(ans); // Expected: 28
  }
}
