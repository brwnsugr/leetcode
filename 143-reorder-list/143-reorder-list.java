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
    public void reorderList(ListNode head) {
        // 1(count = 1) -> 2 -> 3 -> 4
        // map = [2 -> 1], [3 -> 2], [4 -> 3], tail = 4
        // count odd curr.next = tail
        // visitedMap, if the elemtn in the last list haven't visited, connecting to the current nodes' next to the element
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode tail = reverse(slow);
        ListNode dummy = head;

        while(tail.next != null) {
            ListNode temp = head.next;
            head.next = tail;
            head = temp;
            
            temp = tail.next;
            tail.next = head;
            tail = temp;
        }
        
    }
    
    
    private void merge(ListNode left, ListNode right) {
        if(left.next == null) {
            left.next = right;
            return;
        }
        else if(left.next != null) {
            ListNode temp = left.next;
            left.next = right;
            merge(left.next, right.next);
        }
    }
    
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}