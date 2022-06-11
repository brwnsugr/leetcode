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
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false);
        return answer;
    }
    
    private void dfs(TreeNode root, boolean prevEven) {
        if(root == null) return;
        
        boolean currEven = root.val % 2 == 0;
        
        if(root.left!= null) {
            if(prevEven) answer += root.left.val;
            dfs(root.left, currEven);
        }
        if(root.right != null) {
            if(prevEven) answer += root.right.val;
            dfs(root.right, currEven);
        }
    }
}