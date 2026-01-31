// solve again streak 744
public class Jan31NextGreatestLetter {

  // SAME LOGIC AS LEETCODE
  public static char nextGreatestLetter(char[] letters, char target) {

    char ans = letters[0];
    int low = 0;
    int high = letters.length - 1;

    // wrap-around case
    if (letters[high] <= target) {
      return ans;
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;
      char ch = letters[mid];

      if (ch > target) {
        ans = ch;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    char[] letters = { 'c', 'f', 'j' };
    char target = 'c';

    char result = nextGreatestLetter(letters, target);
    System.out.println(result); // Expected: f
  }
}
