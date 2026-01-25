
// sove again after watching video streak ,ques 1984
import java.util.*;

public class Jan25MinimumDifferenceKScores {

  // SAME LOGIC (NO CHANGE)
  public int minimumDifference(int[] nums, int k) {
    int n = nums.length;

    Arrays.sort(nums);

    int minDiff = Integer.MAX_VALUE;

    int i = 0;
    int j = i + k - 1;

    while (j < n) {
      int minElement = nums[i];
      int maxElement = nums[j];

      minDiff = Math.min(minDiff, maxElement - minElement);

      i++;
      j++;
    }

    return minDiff;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 9, 4, 1, 7 };
    int k = 2;

    Jan25MinimumDifferenceKScores obj = new Jan25MinimumDifferenceKScores();

    int ans = obj.minimumDifference(nums, k);

    System.out.println(ans); // Output: 2
  }
}
