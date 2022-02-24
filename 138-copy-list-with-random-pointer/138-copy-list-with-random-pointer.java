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
    private Map<Node, Node> visitedMap;

    
    public Node copyRandomList(Node head) {
        
        /*
        High Level Approach
        Iterating over the list, creating new cloned node with its cloned random pointer and the cloned next pointer 
        which is mapping one by one to the original nodes.
        
        
        A(R: D)->B(R: A)->C(R: A)->D(R: A)
        
        A'(R: ^D') -> ... -> ^D'()
        
        Map[(A, A'), (D, D')]
        
        ^D == ^D  -> key: D, value : D'
        */
        
        if(head == null) return null;
        
        visitedMap = new HashMap<>();
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visitedMap.put(oldNode, newNode);
        
        while(oldNode != null) {
            newNode.next = getClone(oldNode.next);
            newNode.random = getClone(oldNode.random);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        
        return visitedMap.get(head);
    }
    
    private Node getClone(Node curr) {
        if(curr==null) return null;
        if(!visitedMap.containsKey(curr)) {
            visitedMap.put(curr, new Node(curr.val)); 
        }
        return visitedMap.get(curr);
    }
}