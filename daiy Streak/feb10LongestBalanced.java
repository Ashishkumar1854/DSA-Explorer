
//copy pashte so solve again question no is 3719
import java.util.*;

public class feb10LongestBalanced {

  // SAME LOGIC (NO CHANGE)
  public static int longestBalanced(int[] nums) {
    int n = nums.length;
    int maxLen = 0;

    for (int i = 0; i < n; i++) {
      Set<Integer> even = new HashSet<>();
      Set<Integer> odd = new HashSet<>();

      for (int j = i; j < n; j++) {
        if (nums[j] % 2 == 0) {
          even.add(nums[j]);
        } else {
          odd.add(nums[j]);
        }

        if (even.size() == odd.size()) {
          maxLen = Math.max(maxLen, j - i + 1);
        }
      }
    }

    return maxLen;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums1 = { 1, 2, 3, 4 };
    int[] nums2 = { 2, 4, 6, 1, 3 };

    System.out.println(longestBalanced(nums1)); // Output example: 4
    System.out.println(longestBalanced(nums2)); // Output example: 4
  }
}
