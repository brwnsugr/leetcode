/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        // cyclic하게, Fast와 slow 가 돌다보면 결국 만남 
        // why must meet, if it's cycle?
        // 속도의 차이 때문임. cyclic하고, 속도의 차이가 1이면 결국 만날수밖에 없음. 시침, 분침이 한번은 만나는 것과 똑같음
        // worst case 일 때는, 
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return true;
    }
}