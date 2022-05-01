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
    public TreeNode deleteNode(TreeNode root, int key) {
        //lookup key 
        return removeNode(root, key);
    }
    
    private TreeNode removeNode(TreeNode node, int key) {
        if(node == null) return null;
        
        if(key > node.val) {
            node.right = removeNode(node.right, key); 
        }
        else if( key < node.val) {
            node.left = removeNode(node.left, key);
        }
        else {
            if(node.left == null && node.right == null) node = null;
            else if(node.right != null) {
                node.val = successor(node);
                node.right = removeNode(node.right, node.val);
            }
            else if(node.left != null) {
                node.val = predecessor(node);
                node.left = removeNode(node.left, node.val);
            }
        }
        return node;
    }
    
    private int successor(TreeNode node) {
        node = node.right;
        while(node.left != null) {
            node = node.left;
        }
        return node.val;
    }
    
    private int predecessor(TreeNode node) {
        node = node.left;
        while(node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}