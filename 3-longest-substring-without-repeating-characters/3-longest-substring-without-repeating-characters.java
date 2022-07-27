class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        // abcab -> [2,1,1]
        
        int r = 0;
        int l = 0;
        int[] count = new int[128];
        int answer = 0;
        
        while( r < s.length()) {
            char curr = s.charAt(r);
            
            count[curr]++;
            
            while(count[curr] > 1) {
                char leftCh = s.charAt(l);
                count[leftCh]--;
                l++;
            }
            
            answer = Math.max(answer, r - l + 1);
            
            r++;
        }
        return answer;
    }
}