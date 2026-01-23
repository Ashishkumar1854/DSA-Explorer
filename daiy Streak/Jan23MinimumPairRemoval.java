
//again solve streak 3510
import java.util.*;

public class Jan23MinimumPairRemoval {

  static class Pair {
    long sum;
    int idx;

    Pair(long sum, int idx) {
      this.sum = sum;
      this.idx = idx;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Pair))
        return false;
      Pair p = (Pair) o;
      return sum == p.sum && idx == p.idx;
    }

    @Override
    public int hashCode() {
      return Objects.hash(sum, idx);
    }
  }

  // SAME LOGIC (NO CHANGE)
  public int minimumPairRemoval(int[] nums) {
    int n = nums.length;

    long[] temp = new long[n];
    for (int i = 0; i < n; i++)
      temp[i] = nums[i];

    TreeSet<Pair> minPairSet = new TreeSet<>(
        (a, b) -> {
          if (a.sum != b.sum)
            return Long.compare(a.sum, b.sum);
          return Integer.compare(a.idx, b.idx);
        });

    int[] nextIndex = new int[n];
    int[] prevIndex = new int[n];

    for (int i = 0; i < n; i++) {
      nextIndex[i] = i + 1;
      prevIndex[i] = i - 1;
    }

    int badPairs = 0;
    for (int i = 0; i < n - 1; i++) {
      if (temp[i] > temp[i + 1])
        badPairs++;
      minPairSet.add(new Pair(temp[i] + temp[i + 1], i));
    }

    int operations = 0;

    while (badPairs > 0) {

      Pair cur = minPairSet.pollFirst();
      int first = cur.idx;
      int second = nextIndex[first];

      int left = prevIndex[first];
      int right = nextIndex[second];

      if (temp[first] > temp[second])
        badPairs--;

      if (left >= 0) {
        if (temp[left] > temp[first] &&
            temp[left] <= temp[first] + temp[second])
          badPairs--;
        else if (temp[left] <= temp[first] &&
            temp[left] > temp[first] + temp[second])
          badPairs++;
      }

      if (right < n) {
        if (temp[right] >= temp[second] &&
            temp[right] < temp[first] + temp[second])
          badPairs++;
        else if (temp[right] < temp[second] &&
            temp[right] >= temp[first] + temp[second])
          badPairs--;
      }

      if (left >= 0) {
        minPairSet.remove(new Pair(temp[left] + temp[first], left));
        minPairSet.add(new Pair(temp[left] + temp[first] + temp[second], left));
      }

      if (right < n) {
        minPairSet.remove(new Pair(temp[second] + temp[right], second));
        minPairSet.add(new Pair(temp[first] + temp[second] + temp[right], first));
        prevIndex[right] = first;
      }

      nextIndex[first] = right;
      temp[first] += temp[second];

      operations++;
    }

    return operations;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    int[] nums = { 5, 2, 3, 1 };

    Jan23MinimumPairRemoval obj = new Jan23MinimumPairRemoval();
    int ans = obj.minimumPairRemoval(nums);

    System.out.println(ans); // Output: 2
  }
}
