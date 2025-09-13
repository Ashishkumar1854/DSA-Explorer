// again see concept of yt code army 
public class LongestSubstringNoRepeat {
  public int lengthOfLongestSubstring(String s) {
    boolean[] count = new boolean[256]; // ASCII character tracker
    int first = 0, second = 0, len = 0;

    while (second < s.length()) {
      char ch = s.charAt(second);

      // repeating char → shrink window
      while (count[ch]) {
        count[s.charAt(first)] = false;
        first++;
      }

      // mark current char as seen
      count[ch] = true;

      // update length
      len = Math.max(len, second - first + 1);

      second++;
    }
    return len;
  }

  // ✅ Test in VS Code
  public static void main(String[] args) {
    LongestSubstringNoRepeat sol = new LongestSubstringNoRepeat();
    System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(sol.lengthOfLongestSubstring("pwwkew")); // 3
  }
}
