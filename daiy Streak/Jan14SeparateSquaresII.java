
//again solve because now i copy phaste only withou knowing concept
import java.util.*;

public class Jan14SeparateSquaresII {

  static class Event {
    double y;
    double x1, x2;
    int type; // +1 add, -1 remove

    Event(double y, double x1, double x2, int type) {
      this.y = y;
      this.x1 = x1;
      this.x2 = x2;
      this.type = type;
    }
  }

  // Segment Tree to maintain union length on X-axis
  static class SegTree {
    int n;
    double[] len;
    int[] count;
    double[] xs;

    SegTree(double[] xs) {
      this.xs = xs;
      this.n = xs.length - 1;
      len = new double[4 * n];
      count = new int[4 * n];
    }

    void update(int idx, int l, int r, int ql, int qr, int val) {
      if (ql >= r || qr <= l)
        return;

      if (ql <= l && r <= qr) {
        count[idx] += val;
      } else {
        int mid = (l + r) / 2;
        update(idx * 2, l, mid, ql, qr, val);
        update(idx * 2 + 1, mid, r, ql, qr, val);
      }

      if (count[idx] > 0) {
        len[idx] = xs[r] - xs[l];
      } else if (l + 1 == r) {
        len[idx] = 0;
      } else {
        len[idx] = len[idx * 2] + len[idx * 2 + 1];
      }
    }

    double query() {
      return len[1];
    }
  }

  public double separateSquares(int[][] squares) {

    List<Event> events = new ArrayList<>();
    Set<Double> xSet = new HashSet<>();

    for (int[] s : squares) {
      double x1 = s[0];
      double y1 = s[1];
      double l = s[2];

      double x2 = x1 + l;
      double y2 = y1 + l;

      events.add(new Event(y1, x1, x2, +1));
      events.add(new Event(y2, x1, x2, -1));

      xSet.add(x1);
      xSet.add(x2);
    }

    double[] xs = xSet.stream().mapToDouble(Double::doubleValue).sorted().toArray();
    Map<Double, Integer> xIndex = new HashMap<>();
    for (int i = 0; i < xs.length; i++)
      xIndex.put(xs[i], i);

    events.sort(Comparator.comparingDouble(e -> e.y));

    SegTree st = new SegTree(xs);
    double totalArea = 0.0;
    double prevY = events.get(0).y;

    // First sweep → total union area
    for (Event e : events) {
      double currY = e.y;
      totalArea += st.query() * (currY - prevY);

      st.update(1, 0, st.n,
          xIndex.get(e.x1),
          xIndex.get(e.x2),
          e.type);

      prevY = currY;
    }

    // Second sweep → find split line
    st = new SegTree(xs);
    double half = totalArea / 2.0;
    double area = 0.0;
    prevY = events.get(0).y;

    for (Event e : events) {
      double currY = e.y;
      double coveredX = st.query();
      double delta = coveredX * (currY - prevY);

      if (area + delta >= half) {
        return prevY + (half - area) / coveredX;
      }

      area += delta;

      st.update(1, 0, st.n,
          xIndex.get(e.x1),
          xIndex.get(e.x2),
          e.type);

      prevY = currY;
    }

    return prevY;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[][] squares = {
        { 0, 0, 2 },
        { 1, 1, 1 }
    };

    Jan14SeparateSquaresII obj = new Jan14SeparateSquaresII();
    double ans = obj.separateSquares(squares);

    System.out.printf("%.5f%n", ans); // Expected: 1.00000
  }
}
