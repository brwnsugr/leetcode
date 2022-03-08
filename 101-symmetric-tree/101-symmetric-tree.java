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
        int leftVal = root.left == null ? -101 : root.left.val;
        int rightVal = root.right == null ? -101 : root.right.val;
        if(leftVal != rightVal) return false;
        return recursive(root.left, root.right);
    }
    
    private boolean recursive(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        int leftLeftVal = left.left == null ? -101 : left.left.val;
        int rightRightVal = right.right == null ? -101 : right.right.val;
        
        int leftRightVal = left.right == null ? -101 : left.right.val;
        int rightLeftVal = right.left == null ? -101 : right.left.val;
        
        if(leftLeftVal == rightRightVal 
               && leftRightVal == rightLeftVal 
               && recursive(left.left, right.right)
               && recursive(left.right, right.left)) { 
                return true;
        }
        return false;
        
    }
    
    
}