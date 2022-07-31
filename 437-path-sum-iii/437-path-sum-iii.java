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
    private int count = 0;
    private int target;
    Map<Long, Integer> prefixSumMap = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        preOrder(root, 0);
        return count;
    }
    
    
    private void preOrder(TreeNode root, long currSum) {
        if(root == null) return;
        
        currSum += root.val;
        
        if(currSum == target) count++;
        
        count += prefixSumMap.getOrDefault(currSum - target, 0);
        
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);
        
        preOrder(root.left, currSum);
        preOrder(root.right, currSum);
        
        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);
    }
}