
//solve again question no 3640 streak feb04,2026
import java.util.*;

public class feb04MaxSumTrionic {

  int n;
  long[][] memo;
  static final long NEG_INF = Long.MIN_VALUE / 2;

  // SAME LOGIC (NO CHANGE)
  long solve(int i, int trend, int[] nums) {
    if (i == n) {
      return (trend == 3) ? 0 : NEG_INF;
    }

    if (memo[i][trend] != Long.MIN_VALUE) {
      return memo[i][trend];
    }

    long take = NEG_INF;
    long skip = NEG_INF;

    // Skip (only before sequence starts)
    if (trend == 0) {
      skip = solve(i + 1, 0, nums);
    }

    // If trionic pattern already completed
    if (trend == 3) {
      take = nums[i];
    }

    if (i + 1 < n) {
      int curr = nums[i];
      int next = nums[i + 1];

      if (trend == 0 && next > curr) {
        take = Math.max(take, curr + solve(i + 1, 1, nums));
      } else if (trend == 1) {
        if (next > curr) {
          take = Math.max(take, curr + solve(i + 1, 1, nums));
        } else if (next < curr) {
          take = Math.max(take, curr + solve(i + 1, 2, nums));
        }
      } else if (trend == 2) {
        if (next < curr) {
          take = Math.max(take, curr + solve(i + 1, 2, nums));
        } else if (next > curr) {
          take = Math.max(take, curr + solve(i + 1, 3, nums));
        }
      } else if (trend == 3 && next > curr) {
        take = Math.max(take, curr + solve(i + 1, 3, nums));
      }
    }

    return memo[i][trend] = Math.max(take, skip);
  }

  public long maxSumTrionic(int[] nums) {
    n = nums.length;
    memo = new long[n][4];

    // Initialize memo
    for (int i = 0; i < n; i++) {
      Arrays.fill(memo[i], Long.MIN_VALUE);
    }

    return solve(0, 0, nums);
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    feb04MaxSumTrionic obj = new feb04MaxSumTrionic();

    int[] nums1 = { 1, 3, 5, 4, 2, 6, 7 };
    int[] nums2 = { 5, 4, 3, 2, 1 };

    System.out.println(obj.maxSumTrionic(nums1)); // valid trionic → prints max sum
    System.out.println(obj.maxSumTrionic(nums2)); // not trionic → very small / NEG_INF
  }
}
