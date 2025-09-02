
public class RomanToInteger {
  public static void main(String[] args) {
    Solution sol = new Solution();

    String s1 = "III";
    String s2 = "IV";
    String s3 = "LVIII";
    String s4 = "MCMXCIV";

    System.out.println("Input: " + s1 + " → Output: " + sol.romanToInt(s1));
    System.out.println("Input: " + s2 + " → Output: " + sol.romanToInt(s2));
    System.out.println("Input: " + s3 + " → Output: " + sol.romanToInt(s3));
    System.out.println("Input: " + s4 + " → Output: " + sol.romanToInt(s4));
  }
}

class Solution {
  public int romanToInt(String s) {
    // map roman numerals to their values
    int[] values = new int[26];
    values['I' - 'A'] = 1;
    values['V' - 'A'] = 5;
    values['X' - 'A'] = 10;
    values['L' - 'A'] = 50;
    values['C' - 'A'] = 100;
    values['D' - 'A'] = 500;
    values['M' - 'A'] = 1000;

    int total = 0;
    for (int i = 0; i < s.length(); i++) {
      int curr = values[s.charAt(i) - 'A'];
      // if next symbol is larger → subtract current
      if (i + 1 < s.length() && curr < values[s.charAt(i + 1) - 'A']) {
        total -= curr;
      } else {
        total += curr;
      }
    }
    return total;
  }
}
