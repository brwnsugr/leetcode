class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] charCounts = new int[26];
        int answer = 1;
        //  ^ -> requiredCount = windowLen - largestMaxCount
        // Z(SA)AAB
        while(r < s.length()) {
            char currChar = s.charAt(r);
            charCounts[currChar - 'A']++;
            
            while(getRequiredRepCount(charCounts, l, r) > k) {
                char leftChar = s.charAt(l);
                charCounts[leftChar -'A']--;
                l++;
            }
            
            answer = Math.max(r - l + 1, answer);
            r++;
        }
        
        
        return answer;
    }
    
    
    private int getRequiredRepCount(int[] charCounts, int start, int end) {
        int totalCnts = 0;
        int maxCharCount = 0;
        
        for(int count : charCounts) {
            totalCnts += count;
            maxCharCount = Math.max(count, maxCharCount);
        }
        
        return totalCnts - maxCharCount;
    }
}