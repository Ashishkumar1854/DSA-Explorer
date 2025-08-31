public class SortVowelInString {
  public static void main(String[] args) {
    Solution sol = new Solution();

    String s1 = "leetcode";
    String s2 = "AbcEIoU";
    String s3 = "Programming";

    System.out.println("Input: " + s1 + " → Output: " + sol.sortVowels(s1));
    System.out.println("Input: " + s2 + " → Output: " + sol.sortVowels(s2));
    System.out.println("Input: " + s3 + " → Output: " + sol.sortVowels(s3));
  }
}

class Solution {
  public String sortVowels(String s) {
    int[] lower = new int[26];
    int[] upper = new int[26];

    char[] arr = s.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      // for lower vowel
      if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
        lower[arr[i] - 'a']++;
        arr[i] = '#';
      }
      // for upper vowel
      else if (arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {
        upper[arr[i] - 'A']++;
        arr[i] = '#';
      }
    }

    String vowel = "";

    // upper
    for (int i = 0; i < 26; i++) {
      char c = (char) ('A' + i);
      while (upper[i] > 0) {
        vowel += c;
        upper[i]--;
      }
    }

    // lower
    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      while (lower[i] > 0) {
        vowel += c;
        lower[i]--;
      }
    }

    // put vowels back
    int first = 0, second = 0;
    while (second < vowel.length()) {
      if (arr[first] == '#') {
        arr[first] = vowel.charAt(second);
        second++;
      }
      first++;
    }

    return new String(arr);
  }
}
