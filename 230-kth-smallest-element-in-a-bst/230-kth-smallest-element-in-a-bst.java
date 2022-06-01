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
    
    private int count = 0;
    private int targetCount;
    TreeNode targetNode = null;
    public int kthSmallest(TreeNode root, int k) {
        targetCount = k;
        inOrder(root);
        return targetNode == null ? 0 : targetNode.val;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        int currVal = root.val;
        count++;
        if(count == targetCount) {
            targetNode = root;
            return;
        }
        inOrder(root.right);
        return;
    }
}