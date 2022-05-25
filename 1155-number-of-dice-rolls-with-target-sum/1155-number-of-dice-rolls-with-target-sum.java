class Solution {
    
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int [n+1][target+1];
        
        dp[0][0] = 1;
        int mod = 1000000007;
        for(int dice = 1; dice <= n; dice++) {
            for(int targetVal = 1; targetVal <= target; targetVal++) {
                for(int currVal = 1; currVal <= k; currVal++) {
                    if(targetVal >= currVal) {
                        dp[dice][targetVal] += dp[dice-1][targetVal - currVal];
                        dp[dice][targetVal] %= mod;
                    }
                }
            }
        }
        
        
        return dp[n][target];
    }

}