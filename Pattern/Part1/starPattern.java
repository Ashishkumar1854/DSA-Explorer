public class starPattern {
  public static void main(String[] arg) {
    for (int line = 1; line <= 4; line++) {
      for (int star = 1; star <= line; star++) {
        System.out.print("*"); // Fixed typo
      }
      System.out.println();
    }
  }
}