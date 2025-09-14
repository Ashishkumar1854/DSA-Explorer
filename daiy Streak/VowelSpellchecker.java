// again solve after study hash ,map and set 14september 

import java.util.*;

public class VowelSpellchecker {
  public static void main(String[] args) {
    Solution sol = new Solution();

    String[] wordlist1 = { "KiTe", "kite", "hare", "Hare" };
    String[] queries1 = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
    System.out.println(Arrays.toString(sol.spellchecker(wordlist1, queries1)));
    // Expected: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

    String[] wordlist2 = { "yellow" };
    String[] queries2 = { "YellOw" };
    System.out.println(Arrays.toString(sol.spellchecker(wordlist2, queries2)));
    // Expected: ["yellow"]
  }
}

class Solution {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    // Step 1: Store exact words
    Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

    // Step 2: Case-insensitive map (lowercase -> first word in wordlist)
    Map<String, String> caseInsensitive = new HashMap<>();

    // Step 3: Vowel-error map (vowel-replaced -> first word in wordlist)
    Map<String, String> vowelInsensitive = new HashMap<>();

    for (String word : wordlist) {
      String lower = word.toLowerCase();
      caseInsensitive.putIfAbsent(lower, word);
      String devoweled = devowel(lower);
      vowelInsensitive.putIfAbsent(devoweled, word);
    }

    // Step 4: Process queries
    String[] result = new String[queries.length];
    for (int i = 0; i < queries.length; i++) {
      String q = queries[i];
      if (exactWords.contains(q)) {
        result[i] = q; // Exact match
      } else {
        String lower = q.toLowerCase();
        if (caseInsensitive.containsKey(lower)) {
          result[i] = caseInsensitive.get(lower); // Case match
        } else {
          String devoweled = devowel(lower);
          result[i] = vowelInsensitive.getOrDefault(devoweled, ""); // Vowel match
        }
      }
    }

    return result;
  }

  // Replace vowels with '*'
  private String devowel(String word) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      if (isVowel(c))
        sb.append('*');
      else
        sb.append(c);
    }
    return sb.toString();
  }

  private boolean isVowel(char c) {
    return "aeiou".indexOf(c) >= 0;
  }
}
