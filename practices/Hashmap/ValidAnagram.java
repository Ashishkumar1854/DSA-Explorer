package practices.Hashmap;

import java.util.HashMap;

public class ValidAnagram {

  public static boolean isAnagram(String s, String t) {
    // Step 1: length check
    if (s.length() != t.length()) {
      return false;
    }

    // Step 2: frequency map for s
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // Step 3: iterate over t and reduce counts
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (map.get(ch) != null) { // exactly like tu likh raha tha
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      } else {
        return false; // character not found
      }
    }

    // Step 4: if map empty → anagram
    return map.isEmpty();
  }

  public static void main(String[] args) {
    String s = "race";
    String t = "care";
    System.out.println(isAnagram(s, t));
  }
}
