class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        dp[0][0] = 0;
        
        
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                char ch1 = text1.charAt(i-1);
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
        //t1 = "ab", t2 = "aa"
        // dp1,1= dp0,0 + 1 = 1
        // dp1, 2 = max(dp 0,2  , dp1,1) // = 1 
        // dp2, 1 = max(dp1,1, dp2,0)  = 1
        // dp2,2= max(dp1,2 , dp2,1) = 
    }
}