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
        if(root == null) return answer;
        preOrder(root, 0);
        return answer;
    }
    
    private void preOrder(TreeNode node, int currHeight) {
        if(node == null) {
            answer = Math.max(answer, currHeight);
            return;
        }
        
        else {
            preOrder(node.left, currHeight + 1);
            preOrder(node.right, currHeight + 1);
        }
    }
    
    
    
    
        
    
    
}