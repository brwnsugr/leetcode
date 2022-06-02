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
    
    private int preOrderIdx = 0;
    Map<Integer, Integer> inorderIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preOrder elements are sorted by root, left subtree's root, right subtree's root
        // pick item of preorder list -
        // inorder = (9)L,3*,(15,20,7)R
        // TC: O(N) , SC: O(N)
        for(int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        int currVal = preorder[preOrderIdx++];
        TreeNode root = new TreeNode(currVal);
        
        root.left = buildTree(preorder, left, inorderIdxMap.get(currVal) - 1);
        root.right = buildTree(preorder, inorderIdxMap.get(currVal)+1, right);
        
        return root;
    }
}