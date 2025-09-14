class FindSubString {
  public int findSubString(String str) {
    int[] count = new int[256];
    int first = 0, sec = 0, len = str.length();
    int diff = 0;

    // calculate all the unique characters
    while (first < str.length()) {
      if (count[str.charAt(first)] == 0) {
        diff++;
      }
      count[str.charAt(first)]++;
      first++;
    }

    // initialize all zero
    for (int i = 0; i < 256; i++) {
      count[i] = 0;
    }
    // reset cursor
    first = 0;

    while (sec < str.length()) {
      // diff exist krta h tb tk
      while (diff > 0 && sec < str.length()) {
        if (count[str.charAt(sec)] == 0)
          diff--;
        count[str.charAt(sec)]++;
        sec++;
      }

      len = Math.min(len, sec - first);

      // diff ki value 1 na ban jaye
      while (diff != 1) {
        len = Math.min(len, sec - first);
        count[str.charAt(first)]--;
        if (count[str.charAt(first)] == 0) {
          diff++;
        }
        first++;
      }
    }
    return len;
  }

  // ✅ Main method for VS Code testing
  public static void main(String[] args) {
    FindSubString solver = new FindSubString();
    String str = "aabcbcdbca"; // example input
    int ans = solver.findSubString(str);
    System.out.println("Smallest substring length containing all unique chars = " + ans);
  }
}
