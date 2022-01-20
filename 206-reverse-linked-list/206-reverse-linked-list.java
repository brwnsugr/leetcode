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
        //list 
        
        if(head == null) return head;
        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        for(int i = arr.size()-1; i >= 0; i--) {
          curr.next = new ListNode(arr.get(i));
          curr = curr.next;
        }

        return dummy.next;
    }
}