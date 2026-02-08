//copy pashte streak question , question no is 110

public class feb08BalancedBinaryTree {

  // 🔹 TreeNode definition (required for VS Code)
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // ✅ SAME LOGIC (NO CHANGE)
  public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  private static int height(TreeNode node) {
    if (node == null)
      return 0;

    int leftHeight = height(node.left);
    if (leftHeight == -1)
      return -1;

    int rightHeight = height(node.right);
    if (rightHeight == -1)
      return -1;

    if (Math.abs(leftHeight - rightHeight) > 1)
      return -1;

    return Math.max(leftHeight, rightHeight) + 1;
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    // Example 1: [3,9,20,null,null,15,7]
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(9);
    root1.right = new TreeNode(20);
    root1.right.left = new TreeNode(15);
    root1.right.right = new TreeNode(7);

    System.out.println(isBalanced(root1)); // true

    // Example 2: [1,2,2,3,3,null,null,4,4]
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(3);
    root2.left.left.left = new TreeNode(4);
    root2.left.left.right = new TreeNode(4);

    System.out.println(isBalanced(root2)); // false
  }
}
