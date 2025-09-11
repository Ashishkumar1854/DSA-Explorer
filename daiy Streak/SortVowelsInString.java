
// date 11/09/2025
import java.util.*;

public class SortVowelsInString {

  public static String sortVowels(String s) {
    int[] lower = new int[26];
    int[] upper = new int[26];

    char[] arr = s.toCharArray();

    // Mark vowels and count frequency
    for (int i = 0; i < arr.length; i++) {
      // lower vowels
      if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
        lower[arr[i] - 'a']++;
        arr[i] = '#';
      }
      // upper vowels
      else if (arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {
        upper[arr[i] - 'A']++;
        arr[i] = '#';
      }
    }

    String vowel = "";

    // Collect uppercase vowels in sorted order
    for (int i = 0; i < 26; i++) {
      char c = (char) ('A' + i);
      while (upper[i] > 0) {
        vowel += c;
        upper[i]--;
      }
    }

    // Collect lowercase vowels in sorted order
    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      while (lower[i] > 0) {
        vowel += c;
        lower[i]--;
      }
    }

    // Put vowels back into the string
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

  public static void main(String[] args) {
    String s1 = "lEetcOde";
    String s2 = "leetcode";

    System.out.println("Input: " + s1 + " → Output: " + sortVowels(s1));
    System.out.println("Input: " + s2 + " → Output: " + sortVowels(s2));
  }
}
