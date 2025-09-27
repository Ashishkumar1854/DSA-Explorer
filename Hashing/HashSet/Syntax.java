package Hashing.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Syntax {

  public static void main(String[] args) {
    // HashSet<Integer> hs = new HashSet<>();
    // hs.add(5);
    // hs.add(4);
    // hs.add(3);
    // hs.add(5);
    // System.out.println(hs);
    // System.out.println(hs.size());
    // System.out.println(hs.isEmpty());

    // hs.remove(4);
    // hs.clear();
    // if (hs.contains(4)) {
    // System.out.println("Element exist");
    // }
    // // if (hs.contains(19)) {
    // // System.out.println("element not exist");
    // // }

    HashSet<String> cities = new HashSet<>();
    cities.add("India");
    cities.add("US");
    cities.add("Rusia");
    cities.add("china");

    // Iterator it = cities.iterator();
    // while (it.hasNext()) {
    // System.out.println(it.next());
    // }

    // advance for loop
    for (String city : cities) {
      System.out.println(city);
    }
  }
}
