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
    
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    List<Integer> answers = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        
        // Map
        fillParentMap(root, null);
        
        // BFS 
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(null);
        q.add(target);
        
        int dist = 0;
        
        
        // Q = [null, target]
        //
        visited.add(target);
        //traverse by BFS 
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();// q = [7,4,1]; 
            if(curr == null) {
                //밑장이 나오면 dist를 체크하고 dist==k -> q 에 있는 모든 원소들을 넣어주고 답 출력
                if(dist == k) {
                    // q에 있는 모든 원소를 넣어줌
                    for(TreeNode item : q) {
                        answers.add(item.val);
                    }
                    return answers;
                }
                dist++; // dist = 2
                q.add(null);
            }
            
            else {
                if(curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left); // q = [null] 
                }
                //right
                if(curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
               // parent
                TreeNode par = parentMap.get(curr);
                if(par != null && !visited.contains(par)) {
                    q.add(par);
                    visited.add(par);
                }
            }
            
        }
        
        return answers;
        
        
        
    }
    
    //fill the parentMap 
    
    private void fillParentMap(TreeNode curr, TreeNode parent) {
        if(curr != null) {
            parentMap.put(curr, parent);
            fillParentMap(curr.left, curr);
            fillParentMap(curr.right, curr);
        }
    }
}