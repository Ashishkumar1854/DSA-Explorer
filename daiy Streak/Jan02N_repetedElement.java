import java.util.*;

public class Jan02N_repetedElement {

    public static void main(String[] args) {

        int[] nums = { 5, 1, 5, 2, 5, 3, 5, 4 };

        Set<Integer> set = new HashSet<>();
        int ans = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
                break;
            }
            set.add(num);
        }

        System.out.println(ans);
    }
}

// //Approach-2 (Using 10^4 Size array ~ Constant Space)
// //T.C : O(n)
// //S.C : O(1)
// class Solution {
// public int repeatedNTimes(int[] nums) {
// int[] freq = new int[10001];

// for (int num : nums) {
// freq[num]++;
// if (freq[num] > 1) // all other elements appear exactly once
// return num;
// }

// return -1;
// }
// }

// //Approach-3 (Without using any extra variable to store space - True Constant
// Space)
// //T.C : O(n)
// //S.C : O(1)
// class Solution {
// public int repeatedNTimes(int[] nums) {
// int n = nums.length;

// for (int i = 2; i < n; i++) {
// if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2])
// return nums[i];
// }

// return nums[n - 1]; //or, nums[0]
// }
// }
