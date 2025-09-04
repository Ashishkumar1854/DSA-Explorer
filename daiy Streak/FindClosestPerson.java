
public class FindClosestPerson {

  public static int findClosest(int x, int y, int z) {
    int dist1 = Math.abs(x - z);
    int dist2 = Math.abs(y - z);
    if (dist1 == dist2) {
      return 0;
    }
    return dist1 < dist2 ? 1 : 2;
  }

  public static void main(String[] args) {
    // Sample tests
    System.out.println(findClosest(2, 7, 4)); // Expected: 1
    System.out.println(findClosest(2, 5, 6)); // Expected: 2
    System.out.println(findClosest(1, 5, 3)); // Expected: 0
  }
}
