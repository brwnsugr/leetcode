class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        //dp[days][jobDifficulty.length] , dp[d][r] = up to d days ~ and 
        // minDiffuclty where up to ~d days and rightmost as r, 
        
        int[][] dp = new int[d+1][jobDifficulty.length + 1];
        
        for(int[] days : dp) Arrays.fill(days, 300001);
        dp[0][0] = 0;
        
        for(int i = 1; i <= d; i++) {
            for(int right = i; right <= jobDifficulty.length; right++) {
                int maxDiffAtRight = 0;
                for(int left = right - 1; left >= i-1; left--) {
                    maxDiffAtRight = Math.max(maxDiffAtRight, jobDifficulty[left]);
                    
                    dp[i][right] = Math.min(dp[i][right], dp[i-1][left] + maxDiffAtRight);
                }
            }
        }
        
        return dp[d][jobDifficulty.length];
    }
}