/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
            Queue<Node> q = new LinkedList<>();
    if(root == null) return null;
    q.add(root);


    while(!q.isEmpty()) {
      Queue<Node> tempQ = new LinkedList<>();

      //다 꺼내기
      while(!q.isEmpty()) {
        Node curr = q.poll();
        if(q.isEmpty()) curr.next = null;
        else curr.next = q.peek();
        tempQ.add(curr);
      }

      while(!tempQ.isEmpty()) {
        Node tempCurr = tempQ.poll();
        if(tempCurr.left == null) break;
        q.add(tempCurr.left);
        q.add(tempCurr.right);
      }
    }
    return root;
    }
}