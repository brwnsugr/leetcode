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
    public ListNode mergeKLists(ListNode[] lists) {
        // [1->2->3], [2->3->4],
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        while(true) {
            boolean allEmpty = true;
            int minListPos = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    
                    int val = lists[i].val;
                    if(val < min) {
                        min = val;
                        minListPos = i;
                    }
                    allEmpty = false;
                }
            }
            if(allEmpty) break;
            
            // add item to the result LL
            
            point.next = new ListNode(min);
            
            //pointer move to r
            lists[minListPos] = lists[minListPos].next;
            
            //point move on to r
            point = point.next;
        }
        return dummy.next;
    }
}