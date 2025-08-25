// 409. Longest Palindrome
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

public class LongestPalindrom {
  public int longestPalindrome(String s) {
    int n = s.length();
    int[] lower = new int[26];
    int[] upper = new int[26];

    // frequency updated
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        lower[ch - 'a']++;
      } else {
        upper[ch - 'A']++;
      }
    }

    int count = 0;
    int odd = 0;
    for (int i = 0; i < 26; i++) {
      // lower
      if (lower[i] % 2 == 0) {
        count += lower[i];
      } else {
        count += lower[i] - 1;
        odd = 1;
      }
      // upper
      if (upper[i] % 2 == 0) {
        count += upper[i];
      } else {
        count += upper[i] - 1;
        odd = 1;
      }
    }
    return count + odd;
  }

  // ✅ Main method to test
  public static void main(String[] args) {
    LongestPalindrom sol = new LongestPalindrom();
    String s = "abccccdd"; // Example input
    int ans = sol.longestPalindrome(s);
    System.out.println("Longest Palindrome Length = " + ans);
  }
}
