
//again solve before end of month .today day 08/09/2025
import java.util.*;

public class ConvertIntegerToNoZeroSum {

  public static int[] getNoZeroIntegers(int n) {
    for (int a = 1; a < n; a++) {
      int b = n - a;
      if (!hasZero(a) && !hasZero(b)) {
        return new int[] { a, b };
      }
    }
    return new int[] {};
  }

  private static boolean hasZero(int num) {
    while (num > 0) {
      if (num % 10 == 0)
        return true;
      num /= 10;
    }
    return false;
  }

  public static void main(String[] args) {
    int n1 = 11;
    int n2 = 1010;

    System.out.println("n = " + n1 + " → " + Arrays.toString(getNoZeroIntegers(n1)));
    System.out.println("n = " + n2 + " → " + Arrays.toString(getNoZeroIntegers(n2)));
  }
}
