
//copy ppashte streak so solve again ,question no is 3634
import java.util.*;

public class feb06MinRemoval {

  // SAME LOGIC (NO CHANGE)
  public static int minRemoval(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);

    int i = 0;
    int maxLen = 1;

    for (int j = 0; j < n; j++) {
      long maxEl = nums[j];
      long minEl = nums[i];

      while (i < j && maxEl > (long) k * minEl) {
        i++;
        minEl = nums[i];
      }

      maxLen = Math.max(maxLen, j - i + 1);
    }

    return n - maxLen;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 1, 3, 6, 2, 5 };
    int k = 2;

    int ans = minRemoval(nums, k);

    System.out.println(ans); // prints minimum removals
  }
}
