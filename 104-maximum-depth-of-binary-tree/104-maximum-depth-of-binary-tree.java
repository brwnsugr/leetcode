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
        // leaf 까지-> max depth 를 갱신 
        if(root == null) return answer;
        updateMaxDepth(root, 1);     //     
        return answer;
        
        
        //              3
        //             9 20     d = 3
        //            2^
    }
    
    private void updateMaxDepth(TreeNode root, int depth) {
        // when we reach out to leaf node
        if(root.left == null && root.right == null) {
            answer = Math.max(depth, answer);
            return;
        }
        
        //recursive left
        if(root.left!= null) updateMaxDepth(root.left, depth + 1);
        // right
        if(root.right != null) updateMaxDepth(root.right, depth + 1);
    }
}