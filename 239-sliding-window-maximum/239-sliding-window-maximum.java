class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans[] = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        int idx = 0;
        ans[idx++] = nums[deque.getFirst()];
        
        for(int i = k; i < nums.length; i++) {
            if(deque.getFirst() <= i - k ) deque.removeFirst();
            
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
            ans[idx] = nums[deque.getFirst()];
            idx++;
        }
        
        return ans;
    }
}