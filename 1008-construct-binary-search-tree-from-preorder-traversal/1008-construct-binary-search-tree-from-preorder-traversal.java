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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode constructBST(int[] preorder, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        TreeNode curr = new TreeNode(preorder[start]);
        int mid = start+1;
        //left side
        
        while(mid < end && preorder[mid] < curr.val) {
            mid++;
        }
        mid = preorder[mid] > curr.val ? mid-1 : end;
        
        
        curr.left = constructBST(preorder, start+1, mid);
        curr.right = constructBST(preorder, mid+1, end);
        
        return curr;
        
    }
}