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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int size = list.size();
        int mid = size / 2 - 1;
        for(int i = 0; i <= mid; i++) {
            if(list.get(i) != list.get(size - i - 1)) return false;
        }
        return true;
    }
}