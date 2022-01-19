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
  public Node copyRandomList(Node head) {
    if(head == null) return null;
    Node dummy = new Node(0);
    Node copyCurrNode = dummy;

    Node currNode = head;
    int count = 0;
    while(currNode != null) {
      count++;
      Node nodeToAdd = new Node(currNode.val);
      copyCurrNode.next = nodeToAdd;
      copyCurrNode = copyCurrNode.next;
      currNode = currNode.next;
    }

    currNode = head;
    List<Integer> randomIdxList = new ArrayList<>();
    while(currNode != null) {
      if(currNode.random == null) randomIdxList.add(null);
      else randomIdxList.add(count - distToEnd(currNode.random) - 1);
      currNode = currNode.next;
    }


    int nodeIdx = 0;
      
    currNode = dummy.next;

    while(currNode != null) {
      if(randomIdxList.get(nodeIdx) == null) currNode.random = null;
      if(randomIdxList.get(nodeIdx) != null) currNode.random = getNthNode(dummy.next, randomIdxList.get(nodeIdx));

      currNode = currNode.next;
      nodeIdx++;
    }
    return dummy.next;
  }

  public Node getNthNode(Node head, int idx) {
    Node curr = head;
    while(idx > 0) {
      curr = curr.next;
      idx--;
    }
    return curr;
  }

  public int distToEnd(Node currNode) {
    int distToEnd = 0;
    Node startNode = currNode;
    while(startNode.next != null) {
      distToEnd++;
      startNode = startNode.next;
    }
    return distToEnd;
  }
}