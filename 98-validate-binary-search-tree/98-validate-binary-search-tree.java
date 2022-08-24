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
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode curr, Integer min, Integer max) {
        if(curr == null) return true;
        
        if((min != null && min >= curr.val) || (max != null && max <= curr.val)) return false;
        
        return isValid(curr.left, min, curr.val) && isValid(curr.right, curr.val, max);
    }
}