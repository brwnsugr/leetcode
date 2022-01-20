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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;
        
       recursive(curr, list1, list2);
        
       return dummy.next;
    }
    
    private void recursive(ListNode curr, ListNode list1, ListNode list2) {
        while(list1 != null && list2 != null) {
            int val1 = list1 == null ? 101 : list1.val;
            int val2 = list2 == null ? 101 : list2.val;
            if(val1 <= val2) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        
    }
    
}