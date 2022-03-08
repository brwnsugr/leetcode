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
 
    1^
    |\
   2   2
  / \  /\
 3. 4. 4.3
    
 */
class Solution {
    
    private List<Integer> elementsByLevel = new ArrayList<>();
    
    public boolean isSymmetric(TreeNode root) {
        return recursive(root.left, root.right);
    }
    
    private boolean recursive(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val 
           && recursive(left.left, right.right) 
           && recursive(left.right, right.left)) { 
            return true;
        }
        return false;
        
    }
    
    
}