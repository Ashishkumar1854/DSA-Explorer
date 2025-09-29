package practices.Hashmap;

import java.util.HashMap;

public class SubarraySumEqualsK {

  public static void main(String[] args) {
    int nums[] = { 10, 2, -2, -20, 10 };
    int k = -10;

    HashMap<Integer, Integer> map = new HashMap<>();
    // sum,count
    map.put(0, 1);

    int sum = 0, ans = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    System.out.println(ans);

  }
}
