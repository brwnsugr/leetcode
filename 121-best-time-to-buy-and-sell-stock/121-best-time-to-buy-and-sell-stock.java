class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0] : til i-1 idx, max profit holding stock
        //dp[i][1] : til i-1 idx, max profit not holding stock
        
        //dp[i][1] =Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        
        int[][] dp = new int[prices.length+1][2];
        
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}