public class StringRotatedby2Places {

  public static boolean isRotated(String s1, String s2) {
    // If lengths differ, can't be rotations
    if (s1.length() != s2.length())
      return false;

    // Strings of length <= 2 can only be equal
    if (s1.length() <= 2)
      return s1.equals(s2);

    int n = s1.length();

    // Anticlockwise rotation by 2 → move first 2 chars to the end
    String left = s1.substring(2) + s1.substring(0, 2);
    if (s2.equals(left)) {
      return true;
    }

    // Clockwise rotation by 2 → move last 2 chars to the front
    String right = s1.substring(n - 2) + s1.substring(0, n - 2);
    if (s2.equals(right)) {
      return true;
    }

    // If neither matched
    return false;
  }

  // testing
  public static void main(String[] args) {
    System.out.println(isRotated("amazon", "azonam")); // true
    System.out.println(isRotated("geeksforgeeks", "geeksgeeksfor")); // false
    System.out.println(isRotated("ab", "ab")); // true
  }
}
