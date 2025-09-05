//05/09/25
public class MinimumOperationsToMakeIntegerZero {
  public static void main(String[] args) {
    Solution sol = new Solution();

    // 🔹 Sample test cases
    System.out.println(sol.makeTheIntegerZero(12, -2)); // Example
    System.out.println(sol.makeTheIntegerZero(2, 1)); // Expected 1
    System.out.println(sol.makeTheIntegerZero(3, 1)); // Example
    System.out.println(sol.makeTheIntegerZero(0, -5)); // Expected 0
  }
}

class Solution {
  public int makeTheIntegerZero(int num1, int num2) {
    if (num1 == 0)
      return 0;

    for (int k = 1; k <= 60; k++) {
      long target = (long) num1 - (long) num2 * k;

      if (target < 0) {
        if (num2 > 0)
          break;
        else
          continue;
      }

      int bits = Long.bitCount(target);
      if (bits <= k && k <= target) {
        return k;
      }
    }
    return -1;
  }
}
