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
    
    List<Integer> answers = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        //in order
        //  Left -> Root -> Right
        // 
        //
        // left subtree
        inOrder(root);
        
        return answers;
        
        //
    }
    
    private void inOrder(TreeNode curr) {
            //3
        if(curr == null) return;
        // 1. left node
        inOrder(curr.left);
        
        // 2. root node 
        answers.add(curr.val); // answers = [1, 3, 2]
        
        // 3. right node 
        inOrder(curr.right);//
        
    }
}