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
        path.addLast(root.val);
        recursive(root, path, root.val);
        return answers;
    }
    
    private void recursive(TreeNode root, LinkedList<Integer> path, int tempSum) {
        //meet leaf node
        if(root.left == null && root.right == null) {
            if(tempSum == target) answers.add(new ArrayList<>(path));
            return;
        }

        
        if(root.left != null){
            path.addLast(root.left.val);
            recursive(root.left, path, tempSum + root.left.val);
            path.removeLast();
        } 
        
    
        if(root.right != null) {
            path.addLast(root.right.val);
            recursive(root.right, path, tempSum + root.right.val);
            path.removeLast();
        }
            
    }
}