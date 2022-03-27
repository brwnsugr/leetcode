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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode right = getMidNode(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;
        
        ListNode left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }
    
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        
        tail.next = list1 != null ? list1 : list2;
        return dummyHead.next;
    }
    
    ListNode getMidNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        
        //a -> b -> c
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ListNode mid = midPrev.next;
        // System.out.println("mid val is " + mid.val );
        // midPrev.next = null;
        // slow.next = null;
        return slow;
    }
}