// solve again
//Date 12sep 2025

public class VowelsGameInString {

  public static boolean doesAliceWin(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isVowel(c)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isVowel(char c) {
    return "aeiou".indexOf(c) >= 0;
  }

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "bcdfg";

    System.out.println("Input: " + s1 + " → Alice wins? " + doesAliceWin(s1));
    System.out.println("Input: " + s2 + " → Alice wins? " + doesAliceWin(s2));
  }
}
