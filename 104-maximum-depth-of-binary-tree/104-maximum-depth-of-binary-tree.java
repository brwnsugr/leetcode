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
    
    
    private int answer = 0;
    public int maxDepth(TreeNode root) {
        
        
        if(root == null) return 0;
        
        reachToLeaf(root, 1);
        return answer;
        
    }
    
    private void reachToLeaf(TreeNode root, int depth) {
        if(root.right == null && root.left == null) {
            answer = Math.max(depth, answer);
            return;
        }
        
        else {
            if(root.left != null) reachToLeaf(root.left, depth+1);
            if(root.right != null) reachToLeaf(root.right, depth+1);
        }
        
    } 
    
    
}