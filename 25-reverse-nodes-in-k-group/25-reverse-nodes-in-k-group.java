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

    /**
     * don't need to move the pointer. 
     * Just Need to modify the node's value in Reverse Order by K size group
     * 
     * So, go through the linked list from head
     * I would store the the K sized Group values in order when traverse
     * 
     * 1->2->3->4  k = 2,  1->2 {1,2}  
     * 
     */
    if (head == null) return null;
    
    
    List<Integer> orders = new ArrayList<>();
    int count = 0;
    ListNode curr = head;
    
    ListNode start = null;
    while(curr!=null) {
      count++;
      orders.add(curr.val);
      if(count == 1) {
        start = curr;
      }
      if(count == k) {
        makeReverse(start, orders);
        count = 0;
        orders.clear();
      }
      curr = curr.next;
    }
    return head;
  }
  
  private void makeReverse(ListNode start, List<Integer> orders) {
    if(start == null) return;
    for(int i = orders.size() -1; i>=0; i--) {
      start.val = orders.get(i);
      start = start.next;
    }
  }
}