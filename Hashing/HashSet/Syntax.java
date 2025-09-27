package Hashing.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Syntax {

  public static void main(String[] args) {
    HashSet<Integer> hs = new HashSet<>();
    hs.add(5);
    hs.add(4);
    hs.add(3);
    hs.add(5);
    System.out.println(hs);
    System.out.println(hs.size());
    System.out.println(hs.isEmpty());

    hs.remove(4);
    hs.clear();
    if (hs.contains(4)) {
      System.out.println("Element exist");
    }
    // if (hs.contains(19)) {
    // System.out.println("element not exist");
    // }
  }
}
