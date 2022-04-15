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
    private boolean kFound = false;
    private int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            while(root != null) {
                s.add(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        }
    }

}