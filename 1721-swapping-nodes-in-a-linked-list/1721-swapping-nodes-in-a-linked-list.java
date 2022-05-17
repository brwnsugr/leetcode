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
    public ListNode swapNodes(ListNode head, int k) {
        // save first and its prev
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode firstPrev = null;
        int n = k;
        while(n > 0) {
            firstPrev = first;
            first = first.next;
            n--;
        }
        
        ListNode secondFast = dummy;
        ListNode second = dummy;
        
        for(int i = 0; i < k+1; i++) {
            secondFast = secondFast.next;
        }
        
        ListNode secondPrev = null;
        
        while(secondFast != null) {
            secondPrev = second;
            secondFast = secondFast.next;
            second = second.next;
        }
        
        int val2 = second.next.val;
        int val1 = first.val;
        
        second.next.val = val1;
        first.val = val2;
        
        return dummy.next;
    }
}