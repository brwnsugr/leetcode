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
    
    // private Integer lowerBound = Integer.MIN_VALUE;
    // private int upperBound = Integer.MAX_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;
        else if((lower != null && root.val <= lower) 
                || (upper != null && root.val >= upper)) {
            return false; 
        } 
        else{
            boolean isLeftValid = isValid(root.left, lower, root.val);
            boolean isRightValid = isValid(root.right, root.val, upper);
            return isLeftValid && isRightValid;
        }
        
    }
}