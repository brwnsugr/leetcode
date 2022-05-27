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
    
    private int answer = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        getMaxLength(root);
        return answer;
    }
    
    private int getMaxLength(TreeNode root) {
        if(root == null) return 0;
        
        int leftMax = Math.max(0, getMaxLength(root.left));
        int rightMax = Math.max(0, getMaxLength(root.right));
        
        int maxLength = root.val + leftMax + rightMax;
        
        answer = Math.max(answer, maxLength);
        
        return root.val + Math.max(leftMax, rightMax);
    }
}