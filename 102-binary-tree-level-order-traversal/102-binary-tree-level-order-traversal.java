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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        /*
        
        3 ^                  3 -> q [3]
        | \               
        9   20 ^        q[] -> 3 . q->[9,20] 
        |\  |\
        3 2 1 4 ^      we pop all elements of q at once q[] -> 9,20 . q -> [3,2,1,4] 
        */
        
        
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        TreeNode curr = root;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(curr);
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> arrByLevel = new ArrayList<>();
            for(int i = 0; i < qSize; i++) {
                TreeNode currNode = q.poll();
                arrByLevel.add(currNode.val);
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            answer.add(arrByLevel);
        }
        return answer;
    }
}