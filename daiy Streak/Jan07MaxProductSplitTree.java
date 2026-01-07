//solve again afer learn all concepT of tree

public class Jan07MaxProductSplitTree {

  // Definition for a binary tree node.
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  long totalSum = 0;
  long maxProduct = 0;
  int MOD = 1_000_000_007;

  public int maxProduct(TreeNode root) {

    // 1) total sum of tree
    totalSum = getSum(root);

    // 2) compute best split
    dfs(root);

    return (int) (maxProduct % MOD);
  }

  private long dfs(TreeNode node) {
    if (node == null)
      return 0;

    long left = dfs(node.left);
    long right = dfs(node.right);

    long subSum = left + right + node.val;

    long product = subSum * (totalSum - subSum);
    maxProduct = Math.max(maxProduct, product);

    return subSum;
  }

  private long getSum(TreeNode node) {
    if (node == null)
      return 0;
    return node.val + getSum(node.left) + getSum(node.right);
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    /*
     * Example 1:
     * 1
     * / \
     * 2 3
     * / \ \
     * 4 5 6
     */

    TreeNode root = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(4),
            new TreeNode(5)),
        new TreeNode(
            3,
            null,
            new TreeNode(6)));

    Jan07MaxProductSplitTree obj = new Jan07MaxProductSplitTree();
    int ans = obj.maxProduct(root);

    System.out.println(ans); // Output: 110
  }
}
