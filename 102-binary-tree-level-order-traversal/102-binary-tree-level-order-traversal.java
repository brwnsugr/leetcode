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
    
    private List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        recursive(root, 0);
        return answer;
    }
    
    private void recursive(TreeNode curr, int level) {
        if(level == answer.size()) answer.add(new ArrayList<>());
        answer.get(level).add(curr.val);
        if(curr.left != null) recursive(curr.left, level + 1);
        if(curr.right != null) recursive(curr.right, level + 1);
        return;
    }
}