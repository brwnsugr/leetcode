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
    int answer;
    public int diameterOfBinaryTree(TreeNode root) {
        answer = 0;
        getLongest(root);
        return answer;
    }
    
    private int getLongest(TreeNode curr) {
        if(curr==null) return 0;
        
        int leftLongest = getLongest(curr.left);
        int rightLongest = getLongest(curr.right);
        
        answer = Math.max(answer, leftLongest + rightLongest);
        return Math.max(leftLongest, rightLongest) + 1;
    }
}