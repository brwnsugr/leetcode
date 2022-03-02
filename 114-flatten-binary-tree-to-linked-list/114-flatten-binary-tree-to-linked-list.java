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
    TreeNode curr;
    TreeNode newCurr;
    private List<Integer> orders = new ArrayList<>();
    private int order = 0;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        curr = root;
        preOrder(curr);
        curr = root;
        recursiveFlatten(curr);
        return;
    }
    
    private void recursiveFlatten(TreeNode curr) {
        if(order == orders.size()-1) {
            curr.val = orders.get(order);
            return;
        }
        if(curr.right == null) curr.right = new TreeNode();
        curr.val = orders.get(order);
        order++;
        curr.left = null;
        recursiveFlatten(curr.right);
    }
    
    private void preOrder(TreeNode curr) {
        if(curr == null) return;
        orders.add(curr.val);
        preOrder(curr.left);
        preOrder(curr.right);
        
    }
}