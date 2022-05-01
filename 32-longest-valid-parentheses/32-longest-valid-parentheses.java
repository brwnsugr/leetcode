class Solution {
    public int longestValidParentheses(String s) {
        //check every consecutive pair of chars int string s,
        //dp[i] : longest length of valid parentheses where valid parentheses at end index i. 
        // if we get s[i]==')' s[i-1] = '(' -> dp[i] = dp[i-2] + 2
        // if we get s[i]==')' s[i-1] == ')'->   ())) ->
        int answer = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr == ')' && prev == '(') {
                dp[i] = 2;
                dp[i] = i > 1 ? dp[i] + dp[i-2] : dp[i];
            }
            else if(curr == ')' && prev == ')' && i >= 3) {
                char prevLongest = (i-dp[i-1] -1 >=0 ) ? s.charAt(i - dp[i-1] - 1) : ')';
                if(prevLongest == '(') {
                    dp[i] = (i >= dp[i-1] + 2) ? 2 + dp[i-1] + dp[i - dp[i-1] -2] : 2 + dp[i-1];
                }
            }
            answer = Math.max(dp[i], answer);
        }
        
        return answer;
    }
}