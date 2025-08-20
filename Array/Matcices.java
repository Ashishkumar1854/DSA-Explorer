import java.util.Scanner;

public class Matcices {
  public static void main(String arg[]) {
    int n = 3, m = 3;
    int matrix[][] = new int[3][3];
    // Input
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    // outpit
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
