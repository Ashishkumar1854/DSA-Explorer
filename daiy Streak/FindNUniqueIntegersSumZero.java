
// again solve .today day 07/09/2025
import java.util.*;

public class FindNUniqueIntegersSumZero {

  public static int[] sumZero(int n) {
    int[] result = new int[n];
    int index = 0;

    for (int i = 1; i <= n / 2; i++) {
      result[index++] = i;
      result[index++] = -i;
    }

    if (n % 2 == 1) {
      result[index] = 0;
    }

    return result;
  }

  public static void main(String[] args) {
    int n1 = 5;
    int n2 = 4;

    System.out.println("n = " + n1 + " → " + Arrays.toString(sumZero(n1)));
    System.out.println("n = " + n2 + " → " + Arrays.toString(sumZero(n2)));
  }
}
