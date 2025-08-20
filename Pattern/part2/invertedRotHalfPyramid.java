public class invertedRotHalfPyramid {

  public static void inverted_rot_half_pyramind(int n) {
    // outer
    for (int i = 1; i <= n; i++) {
      // space
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      // Starts
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.err.println("");
    }
  }

  public static void main(String[] args) {
    inverted_rot_half_pyramind(4);
  }
}
