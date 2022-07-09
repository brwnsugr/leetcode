class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int l = 0;
        int r = 0;
        int[] charCounts = new int[128];
        int maxLength = 0;
        while(r < s.length()) {
            charCounts[s.charAt(r) - '0']++;
            while(l < r && getFormedCount(charCounts) > 2) {
                charCounts[s.charAt(l++)-'0']--;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        } 
        return maxLength;
    }
    
    private int getFormedCount(int[] charCounts) {
        int count = 0;
        for(int charCount : charCounts) {
            if(charCount > 0) count++;
        }
        return count;
    }
    
    
}