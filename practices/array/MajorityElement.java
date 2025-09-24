// class Solution {
// public int majorityElement(int[] nums) {
// int n=nums.length;
// Arrays.sort(nums);
// return nums[n/2];

// }
// }
package practices.array;

import java.util.HashMap;

public class MajorityElement {

  public static void findMajorityElements(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = nums.length;

    // Count frequency
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i])) { // if key exists
        map.put(nums[i], map.get(nums[i]) + 1);
      } else { // if key does not exist
        map.put(nums[i], 1);
      }
    }

    // Print elements appearing more than n/3 times
    for (int key : map.keySet()) {
      if (map.get(key) > n / 3) {
        System.out.println(key);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
    findMajorityElements(nums);
  }
}
