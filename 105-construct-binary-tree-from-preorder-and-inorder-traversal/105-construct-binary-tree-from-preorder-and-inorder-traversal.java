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
    private TreeNode root;
    private int preOrderIdx = 0;
    private Map<Integer, Integer> inOrderIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) inOrderIdxMap.put(inorder[i], i);
        return arrToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrToTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        int currentRootVal = preorder[preOrderIdx++];
        TreeNode root = new TreeNode(currentRootVal);
        root.left = arrToTree(preorder, left, inOrderIdxMap.get(currentRootVal)-1);
        root.right = arrToTree(preorder, inOrderIdxMap.get(currentRootVal)+1, right);
        return root;
    }
}