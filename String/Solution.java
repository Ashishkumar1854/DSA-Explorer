import java.util.*;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    // Map to hold sorted string as key and list of anagrams as value
    HashMap<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
      // Convert word to char array, sort it, and back to string
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);

      // Put into map
      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(word);
    }

    // Return all grouped anagrams
    return new ArrayList<>(map.values());
  }

  // ✅ Main method for testing
  public static void main(String[] args) {
    Solution sol = new Solution();
    String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
    List<List<String>> result = sol.groupAnagrams(input);
    System.out.println(result);
  }
}
