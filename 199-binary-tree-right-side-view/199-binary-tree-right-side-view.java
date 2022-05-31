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
    List<Integer> elementsRight;
    public List<Integer> rightSideView(TreeNode root) {
        elementsRight = new ArrayList<>();
        dfs(root, 0);
        return elementsRight;
    }
    
    private void dfs(TreeNode curr, int level) {
        if(curr == null) return;
        if(elementsRight.size() == level) {
            elementsRight.add(curr.val);
        }
        if(curr.right != null) dfs(curr.right, level+1);
        if(curr.left != null) dfs(curr.left, level+1);
    }
}