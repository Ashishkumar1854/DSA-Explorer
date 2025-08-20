public class invertedHalfPyramidNum {

  public static void inverted_half_pyr_with_Num(int n) {
    for (int i = 1; i <= n; i++) {
      // inner loop
      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

  public static void main(String arg[]) {
    inverted_half_pyr_with_Num(5);
  }
}
