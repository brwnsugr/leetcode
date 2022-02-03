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
    Map<Node, Node> visitedMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node oldNode = head;
        Node newNode = new Node(head.val);
        Node newHead = newNode;
        visitedMap.put(head, newNode);
        
        while(oldNode != null) {
            
            newNode.next = GetClonedNode(oldNode.next);
            newNode.random = GetClonedNode(oldNode.random);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return visitedMap.get(head);
    }
    
    
    private Node GetClonedNode(Node node) {
        if(node == null) return null;
        else if(visitedMap.containsKey(node))  {
            return visitedMap.get(node);
        }
        else {
            visitedMap.put(node, new Node(node.val));
            return visitedMap.get(node);
        }
    }
}