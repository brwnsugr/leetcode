class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean dp[] = new boolean[s.length() + 1];
        // dp[0][0] = true;
        dp[0] = true;
        //dp[i] = up to i'th position the string is breakable
        Set<String> wordSet = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++) {
            for(String word : wordDict) {
                int wordLen = word.length();
                if(wordLen <= i) {
                    dp[i] |= (dp[i-wordLen] && (s.substring(i - wordLen, i).equals(word)));
                }
            }
        }
        
        return dp[s.length()];
    }
}