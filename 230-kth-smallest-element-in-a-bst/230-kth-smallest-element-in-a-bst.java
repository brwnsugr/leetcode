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
    private boolean kFound = false;
    private int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        // N A: [5,3,6,2,4,1] -> [1,2,3^,4,5,6] count = 3 == k ->  
        inOrder(root, k);
        return answer;
    }
    
    private void inOrder(TreeNode curr, int k) {
        
        if(curr != null) {
            if(!kFound) inOrder(curr.left, k);
            count++;
            if(k == count) {
                kFound = true;
                answer = curr.val;
                return;
            }
            if(!kFound) inOrder(curr.right, k);
        }
    }
}