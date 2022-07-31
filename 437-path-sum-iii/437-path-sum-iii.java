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
    
    private int answerCount = 0;
    private int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        calculateFromRoot(root, 0);
        
        if(root != null && root.left != null) pathSum(root.left, targetSum);
        if(root != null && root.right != null) pathSum(root.right, targetSum);
        return answerCount;
    }
    
    private void calculateFromRoot(TreeNode curr, long sum) {
        if(curr == null) return;
        sum += curr.val;
        if(sum == target) answerCount++;
        calculateFromRoot(curr.left, sum);
        calculateFromRoot(curr.right, sum);
    }
}