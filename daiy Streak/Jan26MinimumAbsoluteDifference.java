
//solve again streak question. 1200
import java.util.*;

public class Jan26MinimumAbsoluteDifference {

  // SAME LOGIC (NO CHANGE)
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);

    List<List<Integer>> result = new ArrayList<>();
    int n = arr.length;

    int minDiff = Integer.MAX_VALUE;

    // First pass: find minimum difference
    for (int i = 1; i < n; i++) {
      int diff = arr[i] - arr[i - 1];
      minDiff = Math.min(minDiff, diff);
    }

    // Second pass: collect pairs with min difference
    for (int i = 1; i < n; i++) {
      int diff = arr[i] - arr[i - 1];
      if (diff == minDiff) {
        result.add(Arrays.asList(arr[i - 1], arr[i]));
      }
    }

    return result;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] arr = { 4, 2, 1, 3 };

    Jan26MinimumAbsoluteDifference obj = new Jan26MinimumAbsoluteDifference();

    List<List<Integer>> ans = obj.minimumAbsDifference(arr);

    System.out.println(ans);
    // Output: [[1, 2], [2, 3], [3, 4]]
  }
}
