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
    private LinkedList<Integer> cumulativePathSum = new LinkedList<>();
    private Map<Integer, Integer> pathMap = new HashMap<>();
    private int count;
    private int target;
    
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        
        this.target = targetSum;
        dfs(root, 0);
        return count;
    }
    
    private void dfs(TreeNode root, int currSum) {
        if(root == null) {
            return;
        }

        currSum += root.val;
        if(currSum == target) count++;
        count += pathMap.getOrDefault(currSum - target, 0);
        pathMap.put(currSum, pathMap.getOrDefault(currSum, 0) + 1);
        dfs(root.left, currSum);
        dfs(root.right, currSum);
        pathMap.put(currSum, pathMap.get(currSum) - 1);
        
    }
    
    
}