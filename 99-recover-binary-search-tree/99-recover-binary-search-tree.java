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
    
    private List<Integer> currentList = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        //Naive approach -> traverse by inorder and find a pair that should be changed
        // 1,4(y),2(x),5,6,7,9 -> y <-> x swipe
        
        // 1. inorder traversal -> current List = 
        // 2. current List -> y, x pair find -> 1,5(y)->4-> 2(x),7,9
        
        TreeNode curr = root;
        inOrder(curr);

        boolean descendingFound = false;
        int y = 0;
        int x = 0;
        for(int i = 0; i < currentList.size() - 1; i++) {
            int prev = currentList.get(i);
            int next = currentList.get(i+1);
            if(prev > next) {
                x = next;
                if(!descendingFound) {
                    y = prev;
                    descendingFound = true;
                }
            }
        }
        traverseForReplace(root, x, y);
    }
    
    private void traverseForReplace(TreeNode root, int x, int y) {
        if(root != null) {
            if(root.val == y) root.val = x;
            else if(root.val == x) root.val = y;
            traverseForReplace(root.left, x, y);
            traverseForReplace(root.right, x, y);
        }
    }
    
    
    private void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            currentList.add(root.val);
            inOrder(root.right);
        }
    }
}