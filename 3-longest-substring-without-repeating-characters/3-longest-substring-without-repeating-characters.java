class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Naive Approach:
        // 
        // abcabcbb
        // aaabcda -> store Character and its index using hashmap
        //when we're reaching out to duplicated characters
        // move the anchor to last index of currChar or 
        // a: 0, a:1, a:2, b: 3 (len = 1-0 = 1), currLen = 1++;
        if(s.length() == 0) return 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int answer = Integer.MIN_VALUE;
        int pivot = -1;
        for(int i = 0; i < s.length(); i++) {
            
            char currChar = s.charAt(i);  //      aabc
            if(charIdxMap.containsKey(currChar)) { // a: 0, a: 1 currlen = 1 
                pivot = Math.max(pivot, charIdxMap.get(currChar));
            }
            answer = Math.max(i-pivot, answer);
            charIdxMap.put(currChar, i);
        }
        return answer;
    }
}