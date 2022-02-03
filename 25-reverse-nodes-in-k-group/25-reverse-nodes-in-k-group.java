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
    public ListNode reverseKGroup(ListNode head, int k) {
    
        ListNode curr = head;
        List<Integer> orders = new ArrayList<>();
        
        int count = 0;
        ListNode start = null;
        while(curr != null) {
            count++;
            orders.add(curr.val);
            if(count == 1) {
                start = curr;
            }
            if(count == k) {
                reverseList(start, orders);
                orders.clear();
                count = 0;
            }
            curr = curr.next;
        }
        return head;
    }
    
    
    private void reverseList(ListNode start, List<Integer> orders) {
        if(start == null) return;
        for(int i = orders.size() -1 ; i>=0; i--) {
            start.val = orders.get(i);
            start = start.next;
        }
    }
    
    
}