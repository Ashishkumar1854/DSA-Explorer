//copy phaste so solve agin ,question 3010

public class feb01MinimumCost {

    // SAME LOGIC (NO CHANGE)
    public static int minimumCost(int[] nums) {
        int n = nums.length;

        int firstMin = nums[0];
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < secondMin) {
                thirdMin = secondMin;
                secondMin = nums[i];
            } else if (nums[i] < thirdMin) {
                thirdMin = nums[i];
            }
        }

        return firstMin + secondMin + thirdMin;
    }

    // 🔹 MAIN METHOD (VS CODE RUN)
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 12 }; // INPUT

        int ans = minimumCost(nums);

        System.out.println(ans); // Output: 6
    }
}
