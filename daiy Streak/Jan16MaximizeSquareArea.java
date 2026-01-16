
// again solve after proepr learn concept then solve 
import java.util.*;

public class Jan16MaximizeSquareArea {

  private static final int M = 1_000_000_007;

  // SAME LOGIC (NO CHANGE)
  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

    List<Integer> hList = new ArrayList<>();
    List<Integer> vList = new ArrayList<>();

    for (int x : hFences)
      hList.add(x);
    for (int x : vFences)
      vList.add(x);

    // add boundaries
    hList.add(1);
    hList.add(m);
    vList.add(1);
    vList.add(n);

    Collections.sort(hList);
    Collections.sort(vList);

    Set<Integer> widths = new HashSet<>();

    // all vertical widths
    for (int i = 0; i < vList.size(); i++) {
      for (int j = i + 1; j < vList.size(); j++) {
        widths.add(vList.get(j) - vList.get(i));
      }
    }

    int maxSide = 0;

    // check horizontal heights
    for (int i = 0; i < hList.size(); i++) {
      for (int j = i + 1; j < hList.size(); j++) {
        int height = hList.get(j) - hList.get(i);
        if (widths.contains(height)) {
          maxSide = Math.max(maxSide, height);
        }
      }
    }

    if (maxSide == 0)
      return -1;

    long area = (long) maxSide * maxSide;
    return (int) (area % M);
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int m = 4, n = 3;
    int[] hFences = { 2 };
    int[] vFences = { 2 };

    Jan16MaximizeSquareArea obj = new Jan16MaximizeSquareArea();
    int ans = obj.maximizeSquareArea(m, n, hFences, vFences);

    System.out.println(ans); // Expected Output: 4
  }
}
