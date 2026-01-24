//streak 24 jan question no 1877

import java.util.*;

public class Jan24MinimizeMaxPairSum {

  // SAME LOGIC (NO CHANGE)
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);

    int maxResult = 0;
    int i = 0, j = nums.length - 1;

    while (i < j) {
      int sum = nums[i] + nums[j];
      maxResult = Math.max(maxResult, sum);
      i++;
      j--;
    }

    return maxResult;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 3, 5, 2, 3 };

    Jan24MinimizeMaxPairSum obj = new Jan24MinimizeMaxPairSum();
    int ans = obj.minPairSum(nums);

    System.out.println(ans); // Output: 7
  }
}
