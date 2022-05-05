class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // "************* "
        
        // dp[i] : at ith idx, return true
        // dp[i] = true if dp[i-word.length] && word.substring(i-word.len, i+1) contains in wordDict
        
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        
        Set<String> wordSet = new HashSet<>(wordDict);
        
        
        for(int i = 0; i <= s.length(); i++) {
            for(String word : wordDict) {
                int wordLen = word.length();
                if(i - wordLen >= 0) {
                    if(dp[i-wordLen] && wordSet.contains(s.substring(i-wordLen , i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}