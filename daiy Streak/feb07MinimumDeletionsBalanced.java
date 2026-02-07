//copy pashte so solve again streak 07feb ,question no is 1653

public class feb07MinimumDeletionsBalanced {

  // ✅ Approach-4 (Constant Space)
  // T.C : O(n)
  // S.C : O(1)
  public static int minimumDeletions(String s) {
    int n = s.length();

    // count total 'a' on right side
    int countA = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == 'a')
        countA++;
    }

    int countB = 0;
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {

      if (s.charAt(i) == 'a') {
        countA--; // this 'a' moves from right to left
      }

      // delete all 'b' on left + all 'a' on right
      ans = Math.min(ans, countB + countA);

      if (s.charAt(i) == 'b') {
        countB++;
      }
    }

    return ans;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    String s1 = "aababbab";
    String s2 = "bbaaaaabb";

    System.out.println(minimumDeletions(s1)); // Output: 2
    System.out.println(minimumDeletions(s2)); // Output: 2
  }
}
