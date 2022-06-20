class Solution {
    public int rob(int[] nums) {
        // [ x (,,,,,,, y^)] 
        // [ (x,   ,...,,. )y]
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(getMaxSum(0, nums.length -1, nums), getMaxSum(1, nums.length, nums));
    }
    
    private int getMaxSum(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        
        for(int i = start + 2; i < end; i++) {
            dp[i] =Math.max( dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[end -1];
    }
}