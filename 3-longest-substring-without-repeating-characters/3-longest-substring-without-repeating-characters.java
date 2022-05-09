class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        char[] ch = new char[128];
        
        int l = 0;
        int r = 0;
        int answer = 0;
        // "abb"ch[a]=1, ch[b]=1, 
        while(r < s.length()) {
            char currChar = s.charAt(r);
            ch[currChar]++;
            while(ch[currChar] > 1) {
                char leftChar = s.charAt(l);
                ch[leftChar]--;
                l++;
            }
            answer = Math.max(answer, r - l + 1);
            r++;
        }
        
        return answer;
        
    }
}