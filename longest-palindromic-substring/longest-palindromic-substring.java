class Solution {
    public String longestPalindrome(String s) {
    if(s.length() < 2) return s;
    String ans = "";
    int maxLen = 0;
    int len = s.length();
    boolean[][] dp = new boolean[len][len];

    for(int i = len - 1; i >= 0; i--) {
      for(int j = i; j < len; j++) {
        if(i==j) dp[i][j] = true;
        else if(j-i == 1) dp[i][j] = s.charAt(j) == s.charAt(i);
        else dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);

        if(dp[i][j] && (j-i+1) > maxLen) {
          maxLen = j-i+1;
          ans = s.substring(i, j+1);
        }
      }
    }
    return ans;
    }
}