package Hashing;

import java.util.HashSet;

public class UnionAndIntersectionTwooNum {
  public static void main(String[] args) {
    int arr1[] = { 7, 3, 9 };
    int arr2[] = { 6, 3, 9, 2, 4 };

    HashSet<Integer> set = new HashSet<>();

    // union
    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      set.add(arr2[i]);
    }
    System.out.println("union =" + set.size());

    // intersection
    // set.clear(); // ye bhi kr skte h other hashmset banane ka jarurat nhi hoga
    // pahle vala clear function se clear ho jayega
    HashSet<Integer> set2 = new HashSet<>();
    for (int i = 0; i < arr1.length; i++) {
      set2.add(arr1[i]);
    }

    int count = 0;
    for (int i = 0; i < arr2.length; i++) {
      // element of arr2 exist or not check in set (arr1 in set)
      if (set2.contains(arr2[i])) {
        // if element exist
        count++;
        // and remove so here count increase ho jayega and element delete ho jayega
        // jisse dublicate count na ho
        set2.remove(arr2[i]);
      }
    }
    System.out.println("intersection =" + count);
  }
}
