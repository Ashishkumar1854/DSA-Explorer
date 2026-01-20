
//again solve 
import java.util.*;

public class Jan20MinBitwiseArray {

  // SAME LOGIC (NO CHANGE)
  public int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      int num = nums.get(i);
      boolean found = false;

      for (int x = 0; x < num; x++) {
        if ((x | (x + 1)) == num) {
          result[i] = x;
          found = true;
          break;
        }
      }

      if (!found) {
        result[i] = -1;
      }
    }

    return result;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    List<Integer> nums = Arrays.asList(2, 3, 5, 7);

    Jan20MinBitwiseArray obj = new Jan20MinBitwiseArray();
    int[] ans = obj.minBitwiseArray(nums);

    System.out.println(Arrays.toString(ans));
    // Expected Output: [-1, 1, 4, 3]
  }
}
