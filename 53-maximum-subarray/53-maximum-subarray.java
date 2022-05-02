class Solution {
    public int maxSubArray(int[] nums) {
        //O(N^2)
        int answer = Integer.MIN_VALUE;
        int sum = 0; // [1,-2,3]
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            answer = Math.max(answer, sum);
            if(sum < 0) sum = 0;
            
        }
        return answer;
    }
}