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
    
    private List<List<Integer>> answers = new ArrayList<>();
    private int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        target = targetSum;
        recursive(root, path, 0);
        return answers;
    }
    
    private void recursive(TreeNode root, LinkedList<Integer> path, int tempSum) {
        //meet leaf node
        if(root == null) return;
        path.add(root.val);
        tempSum += root.val;
        if(root.left == null && root.right == null && tempSum == target) {
            answers.add(new ArrayList<>(path));
        }
        else {
            recursive(root.left, path, tempSum);
            recursive(root.right, path, tempSum);
        }
        path.removeLast();
        tempSum -= root.val;
            
    }
}