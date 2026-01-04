
public class Jan04FourDivisors {

  // SAME LOGIC (NO CHANGE)
  private int sumIfFourDivisors(int num) {
    int divisors = 0;
    int sum = 0;

    for (int div = 1; div * div <= num; div++) {
      if (num % div == 0) {
        int other = num / div;

        if (div == other) {
          divisors++;
          sum += div;
        } else {
          divisors += 2;
          sum += div + other;
        }
      }

      if (divisors > 4) {
        return 0;
      }
    }

    return divisors == 4 ? sum : 0;
  }

  public int sumFourDivisors(int[] nums) {
    int result = 0;

    for (int num : nums) {
      result += sumIfFourDivisors(num);
    }

    return result;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 21, 4, 7 }; // INPUT

    Jan04FourDivisors obj = new Jan04FourDivisors();
    int ans = obj.sumFourDivisors(nums);

    System.out.println(ans); // Output: 32
  }
}
