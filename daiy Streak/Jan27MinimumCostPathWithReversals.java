
// again solve streak 3650
import java.util.*;

public class Jan27MinimumCostPathWithReversals {

  static class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
      this.node = node;
      this.dist = dist;
    }
  }

  // SAME LOGIC (NO CHANGE)
  public int minCost(int n, int[][] edges) {

    // Adjacency list: node -> {neighbor, weight}
    Map<Integer, List<Pair>> adj = new HashMap<>();

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int wt = edge[2];

      // original edge
      adj.computeIfAbsent(u, k -> new ArrayList<>())
          .add(new Pair(v, wt));

      // reversed edge (cost = 2 * wt)
      adj.computeIfAbsent(v, k -> new ArrayList<>())
          .add(new Pair(u, 2 * wt));
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

    pq.offer(new Pair(0, 0));

    while (!pq.isEmpty()) {
      Pair cur = pq.poll();
      int node = cur.node;
      int d = cur.dist;

      if (d > dist[node])
        continue;

      if (node == n - 1)
        return d;

      if (!adj.containsKey(node))
        continue;

      for (Pair nei : adj.get(node)) {
        int next = nei.node;
        int wt = nei.dist;

        if (d + wt < dist[next]) {
          dist[next] = d + wt;
          pq.offer(new Pair(next, dist[next]));
        }
      }
    }

    return -1;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int n = 4;
    int[][] edges = {
        { 0, 1, 3 },
        { 3, 1, 1 },
        { 2, 3, 4 },
        { 0, 2, 2 }
    };

    Jan27MinimumCostPathWithReversals obj = new Jan27MinimumCostPathWithReversals();

    int ans = obj.minCost(n, edges);

    System.out.println(ans); // Output: 5
  }
}
