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
    public void flatten(TreeNode root) {
        getFlattenedTail(root);
        
    }
    
    private TreeNode getFlattenedTail(TreeNode root) {
        if(root == null) return null;
        if(root.right == null && root.left == null) return root;
        
        TreeNode leftTail = getFlattenedTail(root.left);
        TreeNode rightTail = getFlattenedTail(root.right);
        
        if(leftTail != null) {
            //append right node to leftTail
            leftTail.right = root.right;
            root.right = root.left; 
            root.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
    }
}