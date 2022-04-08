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
    
    boolean pathSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        pathSum = false;
        if(root == null) return false;
        dfs(root, root.val, targetSum);
        return pathSum;
    }
    
    private void dfs(TreeNode curr, int sum, int targetSum) {
        if(curr.left == null && curr.right == null) {
            if(sum == targetSum) pathSum = true;
            return;
        }
        
        if(curr.left != null) dfs(curr.left, sum + curr.left.val, targetSum);
        if(curr.right != null) dfs(curr.right, sum + curr.right.val, targetSum);
    }
}