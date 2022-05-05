class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            int tempWays = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i >= coin && dp[i-coin] != -1 && dp[i-coin] < tempWays) {
                    tempWays = dp[i-coin];
                }
                dp[i] = tempWays == Integer.MAX_VALUE ? -1 : tempWays + 1;
            }
            
        }
        
        
        return dp[amount];
    }
}