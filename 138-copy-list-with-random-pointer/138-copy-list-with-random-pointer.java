/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  private Map<Node, Node> visitedNodeMap = new HashMap<>();
  public Node copyRandomList(Node head) {
    if(head == null) return null;

    if(visitedNodeMap.containsKey(head)) return visitedNodeMap.get(head);

    Node newNode = new Node(head.val);
    visitedNodeMap.put(head, newNode);

    newNode.next = this.copyRandomList(head.next);
    newNode.random = this.copyRandomList(head.random);

    return newNode;
  }
}