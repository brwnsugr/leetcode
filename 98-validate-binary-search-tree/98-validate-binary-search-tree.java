/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isValidBST(TreeNode root) {

    /**
     * We traverse 1. root 2. left sub tree, 3. right sub tree in order.
     * and everytime we traverse each node, do logic above recursively.
     *
     * once if we would find that from the view of curr node that we're at, its left sub is bigger or right sub is less than curr node,
     * then return false;
     *
     * after All Traversal, without any returning false,
     * then it's obvious that return true
     */

    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode root, Integer low, Integer high) {
    if(root == null) return true;

    if((low != null && low >= root.val) ||(high != null && high <= root.val)) return false;

    return isValid(root.left, low ,root.val) && isValid(root.right, root.val, high);
  }
}