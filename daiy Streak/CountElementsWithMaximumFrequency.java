// 22september 

import java.util.*;

public class CountElementsWithMaximumFrequency {
  static class Solution {
    public int maxFrequencyElements(int[] nums) {
      Map<Integer, Integer> freq = new HashMap<>();
      int maxFreq = 0;

      // Count frequencies
      for (int num : nums) {
        int count = freq.getOrDefault(num, 0) + 1;
        freq.put(num, count);
        maxFreq = Math.max(maxFreq, count);
      }

      int result = 0;
      // Sum frequencies of numbers that occur maxFreq times
      for (int value : freq.values()) {
        if (value == maxFreq) {
          result += value;
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] nums1 = { 1, 2, 2, 3, 1, 4 };
    System.out.println("Output 1: " + sol.maxFrequencyElements(nums1));
    // Expected: 4 (1 occurs 2 times, 2 occurs 2 times → 2+2=4)

    int[] nums2 = { 1, 2, 3, 4, 5 };
    System.out.println("Output 2: " + sol.maxFrequencyElements(nums2));
    // Expected: 5 (all occur once → max=1, total=5)

    int[] nums3 = { 7, 7, 7, 7 };
    System.out.println("Output 3: " + sol.maxFrequencyElements(nums3));
    // Expected: 4 (7 occurs 4 times)
  }
}
