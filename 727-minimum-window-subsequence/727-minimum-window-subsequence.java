class Solution {
    public String minWindow(String s1, String s2) {
        
        // d[i]
        // 
        if(s1 == null || s2 == null) return "";
        
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 1; i <= m; i++) {
            dp[0][i] = Integer.MAX_VALUE/2;
            // dp[0][i] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int i = 1 ; i <=n; i++) {
            if(dp[i][m] < minLen) {
                minLen = dp[i][m];
                idx = i;
            }
        }
        
        
        return minLen > n ? "" : s1.substring(idx - minLen, idx);
        // System.out.println("minlen is " + minLen);
        // return "";
    }
}