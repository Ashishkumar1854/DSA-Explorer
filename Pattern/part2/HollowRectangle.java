public class HollowRectangle {

  public static void hollowRectangle(int totRow, int totCols) {
    // outer lopp
    for (int i = 1; i <= totRow; i++) {
      // inner loop
      for (int j = 1; j <= totCols; j++) {
        // cell (i,j)
        if (i == 1 || i == totRow || j == 1 || j == totCols) {
          // boundry cell
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();

    }
  }

  public static void main(String arg[]) {
    hollowRectangle(4, 5);
  }
}
