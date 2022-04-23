class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp[n][]
        
        int[] dp = new int[366];
        dp[0] = 0;
        
        int index = 0;
        for(int i = 1; i <= 365; i++) {
            if(index == days.length) break;
            if(days[index] == i) {
                dp[i] = dp[i-1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i-7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i-30, 0)] + costs[2]);
                index++;
            }
            else {
                dp[i] = dp[i-1];
            }
            
            
        }
        return dp[days[index-1]];
    }
}