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
    private TreeNode commonAncestor = null;
    private int pVal;
    private int qVal;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pVal = p.val;
        qVal = q.val;
        
        preOrder(root);
        
        return commonAncestor;
    }
    
    private void preOrder(TreeNode root) {
        //       4 
        //     2  5
        //   1  3
        //
        //
        if(root == null) return;
        else if(root.val == pVal || root.val == qVal) {
            commonAncestor = root;
            return;
        }
        else if( (root.val > pVal && root.val < qVal)
               || (root.val > qVal && root.val < pVal)) {
            commonAncestor = root;
            return;
        }
        
        else {
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}