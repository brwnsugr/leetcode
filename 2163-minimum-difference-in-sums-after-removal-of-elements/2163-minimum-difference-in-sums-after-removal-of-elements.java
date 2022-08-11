class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        
        long[] leftSums = new long[nums.length];
        long[] rightSums = new long[nums.length];
        
        Arrays.fill(leftSums, Long.MAX_VALUE);
        Arrays.fill(rightSums, Long.MIN_VALUE);
        
        
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            sum += nums[i];
            
            if(maxHeap.size() > n) {
                int tmpMax = maxHeap.poll();
                sum -= tmpMax;
            }
            
            if(maxHeap.size() == n) {
                leftSums[i] = sum;
            }
        }
        
        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            minHeap.add(nums[i]);
            sum += nums[i];
            
            if(minHeap.size() > n) {
                int tmpMin = minHeap.poll();
                sum -= tmpMin;
            }
            
            if(minHeap.size() == n) {
                rightSums[i] = sum;
            }
        }
        
        
        long answer = Long.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            if(leftSums[i] != Long.MAX_VALUE && rightSums[i+1] != Long.MIN_VALUE) {
                answer = Math.min(answer, leftSums[i] - rightSums[i+1]);    
            }
        }
        
        
        return answer;
    }
}