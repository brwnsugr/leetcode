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
    List<Integer> sortedList;
    int idx = 0;
    public void recoverTree(TreeNode root) {
        //Naive approach -> traverse by inorder and find a pair that should be changed
        // 1,4(y),2(x),5,6,7,9 -> y <-> x swipe
        
        // 1. inorder traversal -> current List = 
        // 2. current List -> y, x pair find -> 1,5(y)->4-> 2(x),7,9
        
        TreeNode curr = root;
        inOrder(curr);

        sortedList = new ArrayList<>(currentList);
        Collections.sort(sortedList);

        traverseForReplace(root);
    }
    
    private void traverseForReplace(TreeNode root) {
        if(root != null) {
            traverseForReplace(root.left);
            int currVal = currentList.get(idx);
            int sortedVal = sortedList.get(idx);
            if(currVal != sortedVal) root.val = sortedVal;
            idx++;
            traverseForReplace(root.right);
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