package Hashing.HashMap;

// import java.util.HashMap;
import java.util.*;

public class Hashing {
  public static void main(String args[]) {
    // country (key), population(value)
    HashMap<String, Integer> map = new HashMap<>();

    // insertion
    map.put("India", 909);
    map.put("Us", 678);
    map.put("China", 1000);

    System.out.println(map);

    // map.put("India", 1000);
    // System.out.print(map);

    // // search
    // if (map.containsKey("china")) {
    // System.out.println("Key is present ");
    // } else {
    // System.out.println("Key is not present ");

    // // check key and value
    // System.out.println(map.get("China"));
    // System.out.println(map.get("china"));
    // }

    // Iteration in hashmap
    // for(int val : arr)
    for (Map.Entry<String, Integer> e : map.entrySet()) {
      System.out.println(e.getKey());
      System.out.println(e.getValue());
    }

    // other for loop used
    Set<String> keys = map.keySet();
    for (String key : keys) {
      System.out.println(key + " " + map.get(key));
    }

    // remove any pair
    map.remove("China");
    System.out.println(map);
  }
}
