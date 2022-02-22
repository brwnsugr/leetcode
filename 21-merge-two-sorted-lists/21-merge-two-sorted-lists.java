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
        ListNode dummy = new ListNode();
        recursiveMerge(dummy, list1, list2);
        
        return dummy.next;
    }
    
    private void recursiveMerge(ListNode curr, ListNode left, ListNode right) {
        if(left == null && right == null) return;
        else if(left == null){
            curr.next = new ListNode(right.val);
            recursiveMerge(curr.next, left, right.next);
        }
        else if(right == null) {
            curr.next = new ListNode(left.val);
            recursiveMerge(curr.next, left.next, right);
        }
        else {
            int value = left.val <= right.val ? left.val : right.val;
            boolean leftFlag = value == left.val ? true : false;
            curr.next = new ListNode(value);
            if(leftFlag) recursiveMerge(curr.next, left.next, right);
            else recursiveMerge(curr.next, left, right.next);
        }
    }
}