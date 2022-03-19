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
    
    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }
    
    private void recursive(TreeNode curr) {
        if(curr == null) return;
        TreeNode left = curr.left;
        curr.left = curr.right;
        curr.right = left;
        recursive(curr.left);
        recursive(curr.right);
        return;
    }
    

}