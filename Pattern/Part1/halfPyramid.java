public class halfPyramid {
  public static void main(String arg[]) {
    int n = 4;
    for (int line = 1; line <= n; line++) {
      for (int num = 1; num <= line; num++) {
        System.out.print(num);
      }
      System.out.println();
    }
  }
}
