class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        
        if(Integer.valueOf(s.substring(0,1)) != 0) dp[1] = 1; 
        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1) != '0') dp[i] = dp[i-1];
            String word = s.substring(i-2, i);
            int wordNum = Integer.valueOf(word);
            if(i >= 2 && wordNum >= 10 && wordNum <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
}