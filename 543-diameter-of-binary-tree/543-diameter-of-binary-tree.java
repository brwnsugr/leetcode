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
    public int diameterOfBinaryTree(TreeNode root) {
    
        
        getHeight(root);
        return answer;
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        answer = Math.max(leftHeight + rightHeight, answer);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}