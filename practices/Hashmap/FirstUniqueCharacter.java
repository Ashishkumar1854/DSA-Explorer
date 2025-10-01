package practices.Hashmap;

import java.util.HashMap;

public class FirstUniqueCharacter {

  // Function to find first unique character in a string
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    // Count frequency of each character
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // Find first unique character
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    return -1; // No unique character found
  }

  // Main method to test the code
  public static void main(String[] args) {
    FirstUniqueCharacter solution = new FirstUniqueCharacter();
    String s = "leetcode";
    System.out.println("Index of first unique character: "
        + solution.firstUniqChar(s));

    s = "loveleetcode";
    System.out.println("Index of first unique character: "
        + solution.firstUniqChar(s));
  }
}
