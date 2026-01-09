
//solve agaian after proper concept here streak break guthub i thnk i'm not push this code in github 
import java.util.*;

public class Jan08MaxDotProduct {

  int m, n;
  int[][] t;

  // SAME LEETCODE LOGIC
  public int maxDotProduct(int[] nums1, int[] nums2) {
    m = nums1.length;
    n = nums2.length;
    t = new int[501][501];

    for (int i = 0; i < 501; i++) {
      Arrays.fill(t[i], -100000000);
    }

    return solve(nums1, nums2, 0, 0);
  }

  public int solve(int[] nums1, int[] nums2, int i, int j) {
    if (i == m || j == n)
      return -100000000;

    if (t[i][j] != -100000000)
      return t[i][j];

    int val = nums1[i] * nums2[j];

    int take_i_j = solve(nums1, nums2, i + 1, j + 1) + val;
    int take_i = solve(nums1, nums2, i, j + 1);
    int take_j = solve(nums1, nums2, i + 1, j);

    t[i][j] = Math.max(val,
        Math.max(take_i_j, Math.max(take_i, take_j)));

    return t[i][j];
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums1 = { 2, 1, -2, 5 };
    int[] nums2 = { 3, 0, -6 };

    Jan08MaxDotProduct obj = new Jan08MaxDotProduct();
    int ans = obj.maxDotProduct(nums1, nums2);

    System.out.println(ans); // Expected Output: 18
  }
}
