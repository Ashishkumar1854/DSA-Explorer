import java.util.*;

public class Jan01PlusOne {

  public static void main(String[] args) {

    int[] digits = { 9, 9, 9 }; // INPUT

    int n = digits.length;
    int i = n - 1;

    while (i >= 0) {
      if (digits[i] < 9) {
        digits[i]++;
        break;
      }
      digits[i] = 0;
      i--;
    }

    int[] result;
    if (i < 0) {
      result = new int[n + 1];
      result[0] = 1;
    } else {
      result = digits;
    }

    System.out.println(Arrays.toString(result));
  }
}
