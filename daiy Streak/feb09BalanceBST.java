
//copypashte streak question so solve again question no is 1382
import java.util.*;

public class feb09BalanceBST {

  // 🔹 TreeNode definition (VS Code ke liye)
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

  // 🔹 Inorder traversal (BST → sorted list)
  private static void inorder(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }

  // 🔹 Build balanced BST from sorted list
  private static TreeNode buildBST(List<Integer> list, int left, int right) {
    if (left > right)
      return null;

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(list.get(mid));

    root.left = buildBST(list, left, mid - 1);
    root.right = buildBST(list, mid + 1, right);

    return root;
  }

  // ✅ SAME LOGIC AS LEETCODE
  public static TreeNode balanceBST(TreeNode root) {
    List<Integer> sorted = new ArrayList<>();
    inorder(root, sorted);
    return buildBST(sorted, 0, sorted.size() - 1);
  }

  // 🔹 Helper: inorder print (for checking output)
  private static void printInorder(TreeNode root) {
    if (root == null)
      return;
    printInorder(root.left);
    System.out.print(root.val + " ");
    printInorder(root.right);
  }

  // 🔹 MAIN METHOD (VS CODE RUN)
  public static void main(String[] args) {

    // Example 1: Unbalanced BST [1,null,2,null,3,null,4]
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);

    System.out.print("Before balancing (inorder): ");
    printInorder(root);
    System.out.println();

    TreeNode balanced = balanceBST(root);

    System.out.print("After balancing (inorder):  ");
    printInorder(balanced);
    System.out.println();
  }
}
