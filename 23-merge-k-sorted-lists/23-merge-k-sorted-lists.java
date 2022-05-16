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
        List<Integer> arr = new ArrayList<>();
        
        for(ListNode list : lists) {
            while(list != null) {
                arr.add(list.val);
                list = list.next;
            }
        }
        if(arr.size() == 0) return null;
        Collections.sort(arr);
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for(int i = 0; i < arr.size(); i++) {
            head.next = new ListNode(arr.get(i));
            head = head.next;
        }
        return dummy.next;
    }
}