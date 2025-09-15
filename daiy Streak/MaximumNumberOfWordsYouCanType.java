// LeetCode 1935: Maximum Number of Words You Can Type
//date 15september 2025

public class MaximumNumberOfWordsYouCanType {
  public static void main(String[] args) {
    String text = "hello world leetcode";
    String brokenLetters = "ad";

    String[] words = text.split(" ");
    int brokenWords = 0;

    for (String word : words) {
      for (char c : word.toCharArray()) {
        if (brokenLetters.indexOf(c) != -1) {
          brokenWords++;
          break;
        }
      }
    }

    int result = words.length - brokenWords;
    System.out.println(result);
  }
}
