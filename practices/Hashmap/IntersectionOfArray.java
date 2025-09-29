// new ArrayList<>() → tum nayi empty list banate ho.

// intersect(a, b) → already ek list return kar raha hai, usko directly assign karna hai.

// //broutforce  solution
// package practices.Hashmap;

// import java.util.*;

// public class IntersectionOfArray {

//   public static ArrayList<Integer> intersect(int[] a, int[] b) {
//     ArrayList<Integer> result = new ArrayList<>();

//     for (int i = 0; i < a.length; i++) {
//       for (int j = 0; j < b.length; j++) {
//         if (a[i] == b[j]) { // match found
//           if (!result.contains(a[i])) { // avoid duplicate
//             result.add(a[i]);
//           }
//           break; // move to next element in a[]
//         }
//       }
//     }
//     return result;
//   }

//   public static void main(String[] args) {
//     int[] a = { 1, 2, 1, 3, 1 };
//     int[] b = { 3, 1, 3, 4, 1 };

//     ArrayList<Integer> ans = intersect(a, b);
//     System.out.println("Brute Force Intersection: " + ans);
//   }
// }

//optinal solution
package practices.Hashmap;

import java.util.*;

public class IntersectionOfArray {

  public static ArrayList<Integer> intersect(int[] a, int[] b) {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<Integer> result = new ArrayList<>();

    // Add all elements of a[] into set
    for (int num : a) {
      set.add(num);
    }

    // Traverse b[]
    for (int num : b) {
      if (set.contains(num)) {
        result.add(num);
        set.remove(num); // avoid duplicates
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 1, 3, 1 };
    int[] b = { 3, 1, 3, 4, 1 };

    ArrayList<Integer> ans = intersect(a, b);
    System.out.println("Intersection: " + ans);
  }
}
