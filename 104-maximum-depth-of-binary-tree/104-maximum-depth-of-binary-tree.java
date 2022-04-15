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
    private int maxDepth = Integer.MIN_VALUE;
    
    public int maxDepth(TreeNode root) {
        
        //traverse with dfs  -> mark the depth with maximum size
        // O(N)
        
        //     3 
        //    2 1
        //
        if(root == null) return 0;
        traverse(root, 1);
        return maxDepth;
    }
    
    private void traverse(TreeNode curr, int depth) {
        //meet leaf node
        if(curr.left == null && curr.right == null) {
            if(depth > maxDepth) maxDepth = depth;
            return;
        }
        if(curr.left != null) traverse(curr.left, depth + 1);
        if(curr.right != null) traverse(curr.right, depth + 1);
    }
}