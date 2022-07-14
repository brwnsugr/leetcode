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
        if(postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);        
        if(postorder.length == 1) return root;
        return recursiveBuild(0, inorder.length-1, 0, postorder.length - 1, inorder, postorder);
    }
    
    
    private TreeNode recursiveBuild(int inStart, int inEnd, int pStart, int pEnd, int[] inorder, int[] postorder) {
        if(pEnd < 0 || inStart > inEnd) return null; 
        TreeNode root = new TreeNode(postorder[pEnd]);

        int pivotVal = postorder[pEnd];
        int pivotIdx = 0;

        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == pivotVal) {
                pivotIdx = i;
                break;
            }
        }
        
        root.left = recursiveBuild(inStart, pivotIdx - 1, 0, pEnd - 1 - inEnd + pivotIdx, inorder, postorder);
        root.right = recursiveBuild(pivotIdx + 1, inEnd, pStart + pivotIdx, pEnd - 1, inorder, postorder);
        return root;
    }
}