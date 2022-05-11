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
        return getReversedList(head);
    }
    
    private ListNode getReversedList(ListNode curr) {
        
        if(curr == null || curr.next == null) return curr;
        // 1->null;
        // 1->2->null  => 2->^1->null
        ListNode p = getReversedList(curr.next);
        curr.next.next = curr;
        curr.next = null;
        
        // switch adj
        // 1<-2->3 ->... ->
        return p;
    }
}