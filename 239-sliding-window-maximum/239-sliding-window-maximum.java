class Solution {
    private ArrayDeque<Integer> deq = new ArrayDeque<>();
    private int[] nums;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n-k+1];
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        
        this.nums = nums;
        int maxIdx = 0;
        
        for(int i = 0; i < k; i++) {
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            if(nums[i] > nums[maxIdx]) maxIdx = i;
            deq.addLast(i);
        }
        
        answer[0] = nums[maxIdx];
        
        for(int i = k; i < n; i++) {
            adjustWindow(i, k);
            deq.addLast(i);
            answer[i - k + 1] = nums[deq.getFirst()];
        }
        
        return answer; 
    }
    
    
    private void adjustWindow(int currIdx, int k) {
        if(!deq.isEmpty() && deq.getFirst() == currIdx - k) {
            deq.removeFirst();
        }
        
        while(!deq.isEmpty() && nums[currIdx] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }
    
    
}