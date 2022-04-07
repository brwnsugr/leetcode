/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answers = new ArrayList<>();
        dfs(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.add(null);
        q.add(target);
        visited.add(target);
        
        int dist = 0;
        
        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();
            
            if(currNode == null) {
                if(dist == k) {
                    for(TreeNode item : q) {
                        answers.add(item.val);
                    }
                    return answers;
                }
                dist++;
                q.add(null);
            }
            else {
                if(currNode.left != null && !visited.contains(currNode.left)) {
                    q.add(currNode.left);
                    visited.add(currNode.left);
                }
                if(currNode.right != null && !visited.contains(currNode.right)) {
                    q.add(currNode.right);
                    visited.add(currNode.right);
                }
                if(parentMap.get(currNode) != null && !visited.contains(parentMap.get(currNode))) {
                    q.add(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }
            }
        }
        
        return answers;
    }
    
    
    private void dfs(TreeNode curr, TreeNode parent) {
        if(curr != null) {
            parentMap.put(curr, parent);
            dfs(curr.left, curr);
            dfs(curr.right, curr);
        }
    }
    
    
}