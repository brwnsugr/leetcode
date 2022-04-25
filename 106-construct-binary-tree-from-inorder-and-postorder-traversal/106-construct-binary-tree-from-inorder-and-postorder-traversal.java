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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // 
        if(inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if(postorder.length == 1) return root;
        int pivotIdx = 0;
        for(int idx = 0; idx < inorder.length; idx++) {
            if(inorder[idx] == root.val) {
                pivotIdx = idx;
                break;
            }
        }
        
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, pivotIdx), Arrays.copyOfRange(postorder, 0, pivotIdx));
        root.right = buildTree(Arrays.copyOfRange(inorder, pivotIdx + 1, inorder.length), Arrays.copyOfRange(postorder, pivotIdx, postorder.length - 1));
        
        
        return root;
    }
}