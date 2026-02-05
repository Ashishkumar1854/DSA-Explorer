
//copy pashte so solve again streak 05feb ,question no 3379. Transformed Array
import java.util.*;

public class feb05ConstructTransformedArray {

  // SAME LOGIC (NO CHANGE)
  public static int[] constructTransformedArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      int shift = nums[i] % n; // keep shift within bounds

      int newIdx = (i + shift) % n;

      // fix negative modulo in Java
      if (newIdx < 0) {
        newIdx += n;
      }

      result[i] = nums[newIdx];
    }

    return result;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 2, -1, 3, 1 };

    int[] ans = constructTransformedArray(nums);

    System.out.println(Arrays.toString(ans));
    // Example output depends on nums
  }
}
