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
  private Map<Node, Node> visitedHashMap = new HashMap<>();

  public Node copyRandomList(Node head) {
    if(head == null) return null;

    Node oldNode = head;
    Node newNode = new Node(head.val);

    visitedHashMap.put(head, newNode);

    while(oldNode != null) {

      newNode.next = getCloneNode(oldNode.next);
      newNode.random = getCloneNode(oldNode.random);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return visitedHashMap.get(head);
  }

  private Node getCloneNode(Node node) {
    if(node == null) return null;
    if(visitedHashMap.containsKey(node)) {
      return visitedHashMap.get(node);
    }
    Node newNode = new Node(node.val);
    visitedHashMap.put(node, newNode);
    return newNode;
  }
}