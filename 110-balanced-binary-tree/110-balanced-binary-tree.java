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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }
    
    private Pair<Boolean, Integer> dfs(TreeNode curr) {
        if(curr == null) return new Pair<Boolean,Integer>(true, 0);
        
        Pair<Boolean, Integer> left = dfs(curr.left);
        Pair<Boolean, Integer> right = dfs(curr.right);
        
        boolean balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);
        
        return new Pair<Boolean, Integer> (balanced, Math.max(left.getValue(), right.getValue()) + 1);
    }
    
    

}