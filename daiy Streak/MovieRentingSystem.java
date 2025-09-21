
//solve again after study hashmap,and hashset .21sep
import java.util.*;

public class MovieRentingSystem {
  private Map<Integer, Map<Integer, Integer>> shopMovies;
  private Map<Integer, TreeSet<int[]>> movieToShops;
  private TreeSet<int[]> rented;

  public MovieRentingSystem(int n, int[][] entries) {
    shopMovies = new HashMap<>();
    movieToShops = new HashMap<>();
    rented = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]));

    for (int[] e : entries) {
      int shop = e[0], movie = e[1], price = e[2];
      shopMovies.putIfAbsent(shop, new HashMap<>());
      shopMovies.get(shop).put(movie, price);

      movieToShops.putIfAbsent(movie, new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
      movieToShops.get(movie).add(new int[] { price, shop });
    }
  }

  public List<Integer> search(int movie) {
    List<Integer> res = new ArrayList<>();
    if (!movieToShops.containsKey(movie))
      return res;

    int count = 0;
    for (int[] entry : movieToShops.get(movie)) {
      if (count == 5)
        break;
      res.add(entry[1]);
      count++;
    }
    return res;
  }

  public void rent(int shop, int movie) {
    int price = shopMovies.get(shop).get(movie);
    movieToShops.get(movie).remove(new int[] { price, shop });
    rented.add(new int[] { price, shop, movie });
  }

  public void drop(int shop, int movie) {
    int price = shopMovies.get(shop).get(movie);
    rented.remove(new int[] { price, shop, movie });
    movieToShops.get(movie).add(new int[] { price, shop });
  }

  public List<List<Integer>> report() {
    List<List<Integer>> res = new ArrayList<>();
    int count = 0;
    for (int[] entry : rented) {
      if (count == 5)
        break;
      res.add(Arrays.asList(entry[1], entry[2]));
      count++;
    }
    return res;
  }

  // Test locally
  public static void main(String[] args) {
    int[][] entries = { { 0, 1, 5 }, { 0, 2, 6 }, { 0, 3, 7 }, { 1, 1, 4 }, { 1, 2, 7 }, { 2, 1, 5 } };
    MovieRentingSystem mrs = new MovieRentingSystem(3, entries);

    System.out.println(mrs.search(1)); // [1, 0, 2]
    mrs.rent(0, 1);
    mrs.rent(1, 2);
    System.out.println(mrs.report()); // [[0,1],[1,2]]
    mrs.drop(1, 2);
    System.out.println(mrs.search(2)); // [0,1]
  }
}
