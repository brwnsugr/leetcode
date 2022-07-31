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
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if(root == null) return new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        trace.add(root.val);
        preOrder(root, trace, root.val);
        
        return answer;
    }
    
    private void preOrder(TreeNode root, List<Integer> trace, int tempSum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(tempSum == target) {
                answer.add(new ArrayList<>(trace));
            }
            return;
        }
        else {
            if(root.left != null) {
                trace.add(root.left.val);
                preOrder(root.left, trace, tempSum + root.left.val);
                trace.remove(trace.size() - 1);
            }
            if(root.right != null) {
                trace.add(root.right.val);
                preOrder(root.right, trace, tempSum + root.right.val);
                trace.remove(trace.size() - 1);
            }     
        }
    }
}