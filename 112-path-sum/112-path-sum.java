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
     
    private boolean targetSumMeet = false;
    private int target;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // root -> leaf : val sum sum == target true
        //       5 -> left, right 
        //.    3(leaf)  2 
        //       currNode.left , right == null  
        // TC: O(N),  
        //
        target = targetSum;
        // targetSumMeet
        //[2], targetSum = 2;
        //.  5
        //  3 2^  ,,   targetSum = 7
        //
        if(root == null) return false;
        recursive(root, root.val);
        return targetSumMeet;
    }
    
    private void recursive(TreeNode curr, int sum) {
        //leaf를 만났을 때 
        if(curr.left == null && curr.right == null) {
            if(sum == target) { // sum = 7
                targetSumMeet = true;
            }
            return;
        }
        
        if(curr.left != null) recursive(curr.left, sum + curr.left.val);
        
        if(curr.right != null) recursive(curr.right, sum + curr.right.val);
    }
}