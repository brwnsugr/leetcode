/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    Set<ListNode> s = new HashSet<>();
    public boolean hasCycle(ListNode head) {
        // try to traverse the listnode from head, 
        // and find the node that we already traversed, then compare the pos and this node. 
        // if position = node -> true, or else return false;
        
        // using hashset we can address. -> put the nodes while traversing, 
        // and check if contains
        
        // 3->2->0->4 :  hashSet: [3, 2* compare with the pos, 0, 4]
        //.   |-----|
        
        // 3(0) -> 2(1)
        
        if(head == null) return false;
        
        ListNode curr = head;
        
        while(curr!=null) {
            if(s.contains(curr)) return true;
            else {
                s.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }
    
}