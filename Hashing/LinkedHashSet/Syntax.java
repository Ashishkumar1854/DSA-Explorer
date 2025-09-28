package Hashing.LinkedHashSet;

import java.util.HashSet;
import java.util.*;

public class Syntax {

  public static void main(String[] args) {

    HashSet<String> cities = new HashSet<>();
    cities.add("India");
    cities.add("US");
    cities.add("Rusia");
    cities.add("china");
    System.out.println(cities);

    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("India");
    lhs.add("US");
    lhs.add("Rusia");
    lhs.add("china");
    System.out.println(lhs);

  }
}
