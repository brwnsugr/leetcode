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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if val < root.val -> root = root.left
        // if val < root.val -> root = root.right
        // 
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null) {
            prev = curr;
            curr = val < curr.val ? curr.left : curr.right;
        }
        if(val < prev.val) {
            prev.left = new TreeNode(val);
        }
        else{
            prev.right = new TreeNode(val);
        }
        return root;
    }
}