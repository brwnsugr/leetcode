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
    private int answer = 0;
    // private boolean kFound = false;
    
    public int kthSmallest(TreeNode root, int k) {
        // approach: in order traverse 해서, k번째 순회 시점의 element를 답으로 낸다.
        // k > # of nodes 
        // TC: 
        
        //.  # of nodes = k 
        inOrder(root, k); 
        return answer;
    }
    
    private void inOrder(TreeNode root, int k) {
        
        if(root != null) {
            inOrder(root.left, k);
            //visit node
            count++;
            if(count == k) {
                answer = root.val;
                return;
            }
            inOrder(root.right, k);
        }
    }
}