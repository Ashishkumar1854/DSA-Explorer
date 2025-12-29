import java.util.*;

public class Dec29PyramidTransition {

  // memo table
  private Map<String, Boolean> t = new HashMap<>();

  public boolean pyramidTransition(String bottom, List<String> allowed) {

    // pair -> possible top chars
    Map<String, List<Character>> mp = new HashMap<>();

    for (String pattern : allowed) {
      String pair = pattern.substring(0, 2);
      char top = pattern.charAt(2);

      if (!mp.containsKey(pair)) {
        mp.put(pair, new ArrayList<>());
      }
      mp.get(pair).add(top);
    }

    return solve(bottom, mp, 0, new StringBuilder());
  }

  private boolean solve(String curr,
      Map<String, List<Character>> mp,
      int idx,
      StringBuilder above) {

    // pyramid complete
    if (curr.length() == 1) {
      return true;
    }

    String key = curr + "_" + idx + "_" + above.toString();
    if (t.containsKey(key)) {
      return t.get(key);
    }

    // current row complete, move to upper row
    if (idx == curr.length() - 1) {
      boolean res = solve(above.toString(), mp, 0, new StringBuilder());
      t.put(key, res);
      return res;
    }

    String pair = curr.substring(idx, idx + 2);
    if (!mp.containsKey(pair)) {
      t.put(key, false);
      return false;
    }

    for (char ch : mp.get(pair)) {
      above.append(ch); // DO
      if (solve(curr, mp, idx + 1, above)) { // EXPLORE
        t.put(key, true);
        return true;
      }
      above.deleteCharAt(above.length() - 1); // UNDO
    }

    t.put(key, false);
    return false;
  }

  // 🔹 MAIN METHOD (HARDCODED INPUT – like LeetCode)
  public static void main(String[] args) {

    Dec29PyramidTransition sol = new Dec29PyramidTransition();

    String bottom = "BCD";
    List<String> allowed = Arrays.asList(
        "BCC",
        "CDE",
        "CEA",
        "FFF");

    boolean ans = sol.pyramidTransition(bottom, allowed);
    System.out.println(ans); // true
  }
}
