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
    
    int answer = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        recursive(root);
        return answer;
    }
    
    private int recursive(TreeNode curr) {
        if(curr == null) return 0;
        
        int leftGain = Math.max(recursive(curr.left), 0);
        int rightGain = Math.max(recursive(curr.right), 0);
    
        int newPathSum = curr.val + leftGain + rightGain;
        answer = Math.max(newPathSum, answer);    
        return curr.val + Math.max(leftGain, rightGain);
    }
}