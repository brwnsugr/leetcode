/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inOrder(root);
        last.right = first;
        first.left = last;
        return first;
    }
    
    private void inOrder(Node curr) {
        if(curr != null) {
            inOrder(curr.left);
            if(last != null){
                curr.left = last;
                last.right = curr;
            }
            else {
                first = curr;
            }
            last = curr;
            inOrder(curr.right);
        }
    }
}