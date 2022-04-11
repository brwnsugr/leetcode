/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //  null -> a(head) -> b -> c
        //   p  <--- curr  -x->next node  curr
        //.   
        // ListNode 
        //
        
        ListNode prev = null;
        
        ListNode curr = head;
        
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
        
    }
}