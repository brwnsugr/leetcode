class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        int answer = 0;
        int start = 0;
        
        for(int end = 0; end < nums.length; end++) {
            
            while(!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                maxQ.pollLast();
            }
            
            while(!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
                minQ.pollLast();
            }
            
            maxQ.addLast(nums[end]);
            minQ.addLast(nums[end]);
            
            if(maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if(nums[start] == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }
                if(nums[start] == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                start++;
            }
            
            answer = Math.max(answer, end - start + 1);
        }
        
        return answer;
    }
}