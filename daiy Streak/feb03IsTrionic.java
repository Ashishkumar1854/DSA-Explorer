
//solve again  question no 3637

public class feb03IsTrionic {

  // SAME LOGIC (NO CHANGE)
  public static boolean isTrionic(int[] nums) {
    int n = nums.length;
    int i = 0;

    // Increasing
    while (i + 1 < n && nums[i] < nums[i + 1]) {
      i++;
    }

    // Must have at least one increasing step and not reach end
    if (i == 0 || i == n - 1)
      return false;

    // Decreasing
    while (i + 1 < n && nums[i] > nums[i + 1]) {
      i++;
    }

    // Must have at least one decreasing step and not reach end
    if (i == n - 1)
      return false;

    // Increasing again
    while (i + 1 < n && nums[i] < nums[i + 1]) {
      i++;
    }

    return i == n - 1;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums1 = { 1, 3, 5, 4, 2, 6, 7 };
    int[] nums2 = { 1, 2, 3, 4, 5 };

    System.out.println(isTrionic(nums1)); // true
    System.out.println(isTrionic(nums2)); // false
  }
}
