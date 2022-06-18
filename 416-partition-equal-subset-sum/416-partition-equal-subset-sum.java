class Solution {
    
    private int subsetTarget;
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum % 2 != 0) return false;
        subsetTarget = totalSum / 2;
        boolean[][] dp = new boolean[nums.length+1][subsetTarget+1];
        
        dp[0][0] = true;
        
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j <= subsetTarget; j++) {
                if(j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[nums.length-1][subsetTarget];
    }

}