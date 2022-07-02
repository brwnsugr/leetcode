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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return isSufficient(root, 0, limit) ? root : null;
        
    }
    
    
    private boolean isSufficient(TreeNode root, int sum, int limit) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return root.val + sum >= limit;
        
        boolean leftSufficient = isSufficient(root.left, sum + root.val, limit);
        boolean rightSufficient = isSufficient(root.right, sum + root.val, limit);
        
        if(!leftSufficient) root.left = null;
        if(!rightSufficient) root.right = null;
        
        return root.left != null || root.right != null;
    }
}