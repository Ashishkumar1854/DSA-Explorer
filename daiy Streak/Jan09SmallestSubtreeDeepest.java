//solve again after proepr learn dfs then again solve this 

public class Jan09SmallestSubtreeDeepest {

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

  // Helper class to store node and depth
  static class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  // SAME LEETCODE LOGIC
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return dfs(root).node;
  }

  private Pair dfs(TreeNode root) {
    if (root == null) {
      return new Pair(null, 0);
    }

    Pair left = dfs(root.left);
    Pair right = dfs(root.right);

    if (left.depth == right.depth) {
      return new Pair(root, left.depth + 1);
    } else if (left.depth > right.depth) {
      return new Pair(left.node, left.depth + 1);
    } else {
      return new Pair(right.node, right.depth + 1);
    }
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    /*
     * Example:
     * 3
     * / \
     * 5 1
     * / \ / \
     * 6 2 0 8
     * / \
     * 7 4
     * Output subtree root = 2
     */

    TreeNode root = new TreeNode(
        3,
        new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(
                2,
                new TreeNode(7),
                new TreeNode(4))),
        new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(8)));

    Jan09SmallestSubtreeDeepest obj = new Jan09SmallestSubtreeDeepest();
    TreeNode ans = obj.subtreeWithAllDeepest(root);

    System.out.println(ans.val); // Output: 2
  }
}
