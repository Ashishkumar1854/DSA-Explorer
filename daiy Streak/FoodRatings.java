// again solve after study hash,hashmap and pririty queue. date 17september

import java.util.*;

public class FoodRatings {
  private Map<String, String> foodToCuisine;
  private Map<String, Integer> foodToRating;
  private Map<String, TreeSet<String>> cuisineToFoods;
  private Map<String, Comparator<String>> cuisineComparators;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    foodToCuisine = new HashMap<>();
    foodToRating = new HashMap<>();
    cuisineToFoods = new HashMap<>();
    cuisineComparators = new HashMap<>();

    for (int i = 0; i < foods.length; i++) {
      String food = foods[i];
      String cuisine = cuisines[i];
      int rating = ratings[i];

      foodToCuisine.put(food, cuisine);
      foodToRating.put(food, rating);

      cuisineComparators.putIfAbsent(cuisine, (a, b) -> {
        int ra = foodToRating.get(a);
        int rb = foodToRating.get(b);
        if (ra != rb)
          return rb - ra; // higher rating first
        return a.compareTo(b); // lexicographically smaller first
      });

      cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(cuisineComparators.get(cuisine)));
      cuisineToFoods.get(cuisine).add(food);
    }
  }

  public void changeRating(String food, int newRating) {
    String cuisine = foodToCuisine.get(food);
    TreeSet<String> foodsSet = cuisineToFoods.get(cuisine);

    // Remove old rating entry
    foodsSet.remove(food);

    // Update rating
    foodToRating.put(food, newRating);

    // Re-insert with updated rating
    foodsSet.add(food);
  }

  public String highestRated(String cuisine) {
    return cuisineToFoods.get(cuisine).first();
  }

  // ---------- Test Locally ----------
  public static void main(String[] args) {
    String[] foods = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
    String[] cuisines = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
    int[] ratings = { 9, 12, 8, 15, 14, 7 };

    FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
    System.out.println(obj.highestRated("korean")); // kimchi
    System.out.println(obj.highestRated("japanese")); // ramen

    obj.changeRating("sushi", 16);
    System.out.println(obj.highestRated("japanese")); // sushi

    obj.changeRating("ramen", 16);
    System.out.println(obj.highestRated("japanese")); // ramen (lexicographically smaller)
  }
}
