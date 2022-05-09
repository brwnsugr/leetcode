class Solution {
    public int characterReplacement(String s, int k) {
        // AABABBA , k 1
        // ABAB
        // AAAABABBA , k = 1
        // ABBBA , k = 1
        // Naive Approach: 
        // Set sliding window using two pointer, 
        // pin the left and right pointer to move on, 
        // in the sliding window, if smaller amount of char's occurance is bigger than k (euqivalent to
        // we don't need to sustain this current sliding window with longest same str with replacement)
        // we move left pointer to the right until that smaller char's occurence is not bigger than k. 
        
        
        
        // TC of this solution would be O(2N) -> O(N) (it iterates at most 2 times of length of String), where N is length of s
        
        //
        int l = 0;
        int r = 0;
        int[] ch = new int[128];
        int answer = 0;
        
        while(r < s.length()) {
            ch[s.charAt(r)]++;
            while(r - l + 1 - (getMaxOccurences(ch)) > k) {
                ch[s.charAt(l)]--;
                l++;
            }
            answer = Math.max(r - l + 1, answer);
            r++;
        }
        return answer;
    }
    
    private int getMaxOccurences(int[] charArr) {
        int res = 0;
        for(int occurence : charArr) {
            res = Math.max(occurence, res);
        }
        return res;
    }
}