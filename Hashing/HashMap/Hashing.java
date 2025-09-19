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

    map.put("India", 1000);
    System.out.print(map);
  }
}
