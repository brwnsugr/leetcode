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
    public int pairSum(ListNode head) {
        
        List<Integer> standardList = new ArrayList<>();
        int answer = 0;
        
        ListNode prev = null;
        while(head != null) {
            standardList.add(head.val);
            ListNode temp = head.next;
            head.next = prev;
            
            prev = head;
            head = temp;
        }
        
        int idx = 0;
        for(int i = 0; i < standardList.size() / 2; i++) {
            answer = Math.max(answer, standardList.get(i) + prev.val);
            prev = prev.next;
        }
        
        return answer;
    }
}