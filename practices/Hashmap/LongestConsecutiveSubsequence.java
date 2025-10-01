package practices.Hashmap;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

  // Function to return length of longest subsequence of consecutive integers.
  public int longestConsecutive(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : arr) {
      set.add(num);
    }

    int longest = 0;

    for (int num : arr) {
      // Check if this is the start of a sequence
      if (!set.contains(num - 1)) {
        int currNum = num;
        int currLen = 1;

        while (set.contains(currNum + 1)) {
          currNum++;
          currLen++;
        }

        longest = Math.max(longest, currLen);
      }
    }

    return longest;
  }

  // Main method to test the code
  public static void main(String[] args) {
    LongestConsecutiveSubsequence solution = new LongestConsecutiveSubsequence();
    int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
    System.out.println("Length of longest consecutive subsequence: "
        + solution.longestConsecutive(arr));
  }
}
