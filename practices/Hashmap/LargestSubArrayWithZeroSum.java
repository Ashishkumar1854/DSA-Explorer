//again solve this question with proper dry run code and revised concept of hashmap
package practices.Hashmap;

import java.util.*;

public class LargestSubArrayWithZeroSum {

  public static void main(String[] args) {
    int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

    HashMap<Integer, Integer> map = new HashMap<>();
    // (sum, ind)
    int sum = 0, len = 0;
    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];
      if (map.containsKey(sum)) {
        // map.get(sum) = i
        len = Math.max(len, j - map.get(sum));
      } else {
        map.put(sum, j);
      }
    }
    System.out.println("largest subarry with zero sum as 0 =>" + len);
  }
}
