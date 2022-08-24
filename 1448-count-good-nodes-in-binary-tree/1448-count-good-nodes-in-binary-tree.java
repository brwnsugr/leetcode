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
    
    public int goodNodes(TreeNode root) {
        preOrder(root, root.val);
        return answer;
    }
    
    private void preOrder(TreeNode curr, int currMax) {
        if(curr == null) return;
        if(curr.val >= currMax) answer++;
        
        preOrder(curr.left, Math.max(currMax, curr.val));
        preOrder(curr.right, Math.max(currMax, curr.val));
    }
}