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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 2 pass
        int len = 0; 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        int steps = len - n;
        ListNode ret = dummy;
        while(steps > 0) {
            dummy = dummy.next;
            steps--;
        }
        
        dummy.next = dummy.next.next;
        
    
        return ret.next;
    }
}