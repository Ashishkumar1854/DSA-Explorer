//solve learn and solve again with proper concept 

import java.util.*;

public class Jan06MaxLevelSum {

  // Definition for a binary tree node.
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // SAME LEETCODE LOGIC
  public int maxLevelSum(TreeNode root) {

    int maxSum = Integer.MIN_VALUE;
    int resultLevel = 1;
    int currLevel = 1;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      int sum = 0;

      while (size-- > 0) {
        TreeNode node = queue.poll();
        sum += node.val;

        if (node.left != null)
          queue.offer(node.left);

        if (node.right != null)
          queue.offer(node.right);
      }

      if (sum > maxSum) {
        maxSum = sum;
        resultLevel = currLevel;
      }

      currLevel++;
    }

    return resultLevel;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    /*
     * Example:
     * 1
     * / \
     * 7 0
     * / \
     * 7 -8
     */

    TreeNode root = new TreeNode(
        1,
        new TreeNode(
            7,
            new TreeNode(7),
            new TreeNode(-8)),
        new TreeNode(0));

    Jan06MaxLevelSum obj = new Jan06MaxLevelSum();
    int ans = obj.maxLevelSum(root);

    System.out.println(ans); // Output: 2
  }
}
