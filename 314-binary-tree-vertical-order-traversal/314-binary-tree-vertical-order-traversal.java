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
    
    int maxColLevel = Integer.MIN_VALUE;
    int minColLevel = Integer.MAX_VALUE;
    List<List<Integer>> answers = new ArrayList<>();
    Map<Integer, List<Integer>> colMap = new HashMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        TreeNode curr = root;
        bfs(curr, 0);
        
        for(int i = minColLevel; i <= maxColLevel; i++) {
            answers.add(colMap.get(i));
        }
        return answers;
    }
    
    private void bfs(TreeNode curr, int colLevel) {
        if(curr == null) return;
        Queue<ColNode> q = new LinkedList<>();
        q.add(new ColNode(0, curr));
        while(!q.isEmpty()) {
            ColNode currNode = q.poll();
            int level = currNode.colLevel;
            minColLevel = Math.min(minColLevel, level);
            maxColLevel = Math.max(maxColLevel, level);
            if(!colMap.containsKey(level)) colMap.put(level, new ArrayList<>());
            colMap.get(level).add(currNode.node.val);
            
            if(currNode.node.left != null) q.add(new ColNode(level - 1, currNode.node.left));
            if(currNode.node.right != null) q.add(new ColNode(level + 1, currNode.node.right));
        }
        return;
    }
    
    static class ColNode {
        int colLevel;
        TreeNode node;
        public ColNode(int colLevel, TreeNode node){
            this.colLevel = colLevel;
            this.node = node;
        }
    }
    
}

