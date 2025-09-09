
// after study DP + Sliding Window again solve this 
import java.util.*;

public class NumberOfPeopleAwareOfSecret {

  public static int peopleAwareOfSecret(int n, int delay, int forget) {
    int MOD = 1000000007;
    long[] dp = new long[n + 1];
    dp[1] = 1;

    long sharing = 0;

    for (int day = 2; day <= n; day++) {
      if (day - delay >= 1) {
        sharing = (sharing + dp[day - delay]) % MOD;
      }
      if (day - forget >= 1) {
        sharing = (sharing - dp[day - forget] + MOD) % MOD;
      }
      dp[day] = sharing;
    }

    long result = 0;
    for (int i = n - forget + 1; i <= n; i++) {
      if (i >= 1) {
        result = (result + dp[i]) % MOD;
      }
    }

    return (int) result;
  }

  public static void main(String[] args) {
    System.out.println(peopleAwareOfSecret(6, 2, 4)); // Output: 5
    System.out.println(peopleAwareOfSecret(4, 1, 3)); // Output: 6
  }
}
