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
    
    private ListNode retNode;
    private ListNode dummy;
    
    public ListNode mergeKLists(ListNode[] lists) {
        // merge lists one by one
        // O(N * k) -> //merge between 2 lists -> (k-1) times, 
        // and per each merge operation, it takes O(N) in the worst case
        // (20 + 40 + 60 + 100)
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode mergeNode = lists[0];
        for(int i = 0; i < lists.length - 1; i++) {
            mergeNode = mergeTwoNodes(mergeNode, lists[i+1]);
        }
        return mergeNode;
     }
    
    
    private ListNode mergeTwoNodes(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ret = h;
        
        while(l1 != null || l2 != null) {
            Integer l1Val = l1 == null ? Integer.MAX_VALUE : l1.val;
            Integer l2Val = l2 == null ? Integer.MAX_VALUE : l2.val;
            if(l1Val < l2Val) {
                h.next = new ListNode(l1Val);
                h = h.next;
                l1 = l1.next;
            }
            else {
                h.next = new ListNode(l2Val);
                l2 = l2.next;
                h = h.next;
            }
        }
        
        return ret.next;
    }
}