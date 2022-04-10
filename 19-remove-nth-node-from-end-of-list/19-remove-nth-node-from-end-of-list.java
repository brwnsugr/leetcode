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
        //Naive approach 
        
        // O(M + M - N) M: size linkedlist element, N = n
        ListNode dummy = head;
        int size = 0;
        while(dummy != null) {
            dummy = dummy.next;
            size++;
        }
        
        int aheadSize = size - n;
        
        dummy = new ListNode(0, head);
        ListNode res = dummy;
        int count = 0;
        while(dummy != null) {
            if(aheadSize == count) {
                //remove next
                dummy.next = dummy.next.next;
                break;
            }
            dummy = dummy.next;
            count++;
        }
        return res.next;
    }
}