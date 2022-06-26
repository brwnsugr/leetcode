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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        if(curr == null) return res;
        if(!isLeaf(curr)) {
            res.add(curr.val);
        }
        
        curr = curr.left;
        while(curr != null) {
            if(!isLeaf(curr)) {
                res.add(curr.val);
            }
            
            if(curr.left != null) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        
        List<Integer> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        res.addAll(leaves);
        
        Stack<Integer> rightBoundaries = new Stack<>();
        curr = root;
        curr = curr.right;
        
        while(curr != null) {
            if(!isLeaf(curr)) rightBoundaries.add(curr.val);
            if(curr.right != null) {
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }
        }
        
        while(!rightBoundaries.isEmpty()) {
            res.add(rightBoundaries.pop());
        }
        
        return res;
    }
    
    private void getLeaves(TreeNode root, List<Integer> res) {
        if(root == null) return;
        
        if(isLeaf(root)) res.add(root.val);
        
        if(root.left != null) getLeaves(root.left, res);
        if(root.right != null) getLeaves(root.right, res);
    }
    
    private boolean isLeaf(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }
}