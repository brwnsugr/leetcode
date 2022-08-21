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
    
    private int answer = 0;
    private Map<Integer, Integer> colIdxStartMap = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return answer;
    }
    
    
    private void dfs(TreeNode curr, int level, int colIdx) {
        if(curr == null) return;
        if(!colIdxStartMap.containsKey(level)) colIdxStartMap.put(level, colIdx);
        int colStartIdx = colIdxStartMap.get(level);
        answer = Math.max(answer, colIdx - colStartIdx + 1);
        dfs(curr.left, level + 1, colIdx * 2);
        dfs(curr.right, level + 1, colIdx * 2 + 1);
    }
    
    
}

