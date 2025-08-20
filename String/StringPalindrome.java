// public class StringPalindrome {

//   public static boolean checkPalindrome(String str) {
//     for (int i = 0; i < str.length() / 2; i++) {
//       int n = str.length();
//       if (str.charAt(i) != str.charAt(n - 1 - i)) {
//         return false;
//       }
//     }
//     return true;
//   }

//   public static void main(String args[]) {
//     String str = "racecar";
//     System.out.println(checkPalindrome(str));
//   }
// }

// public class StringPalindrome {

//   public static float getShortestpath(String path) {
//     int x = 0, y = 0;
//     for (int i = 0; i < path.length(); i++) {
//       char dir = path.charAt(i);
//       // south
//       if (dir == 'S') {
//         y--;
//       }
//       // north
//       else if (dir == 'N') {
//         y++;
//       }
//       // west
//       else if (dir == 'W') {
//         x--;
//       } else {
//         x++;
//       }
//     }

//     int X2 = x * x;
//     int Y2 = y * y;
//     return (float) Math.sqrt(X2 + Y2);
//   }

//   public static void main(String args[]) {
//     String path = "WNEENESENNN";
//     System.out.println(getShortestpath(path));
//   }
// }

// // string comparision
// public class StringPalindrome {

//   public static void main(String args[]) {
//     String s1 = "Ashish";
//     String s2 = "Ashish";
//     String s3 = new String("Ashish");

//     if (s1 == s2) {
//       System.out.println("String are equal");
//     } else {
//       System.out.println("String are not equal");
//     }

//     if (s1 == s3) {
//       System.out.println("String are equal");
//     } else {
//       System.out.println("String are not equal");
//     }
//     if (s1.equals(s3)) {
//       System.out.println("String are equal");
//     } else {
//       System.out.println("String are not equal");
//     }
//   }
// }

//sub string logic
//use prebuild function to find substring likr(0,6)
// public class StringPalindrome {

//   public static String subString(String str, int si, int ei) {
//     String substr = "";
//     for (int i = si; i < ei; i++) {
//       substr = substr + str.charAt(i);
//     }
//     return substr;
//   }

//   public static void main(String args[]) {
//     String str = "HelloWorld";
//     System.out.println(subString(str, 0, 6));
//   }
// }

// For a given set of string ,print a largest string 
public class StringPalindrome {

  public static void main(String args[]) {
    String fruits[] = { "apple", "mango", "banana" };

    String largest = fruits[0];
    for (int i = 0; i < fruits.length; i++) {
      if (largest.compareTo(fruits[i]) < 0) {
        largest = fruits[i];
      }
    }
    System.out.println(largest);
  }
}