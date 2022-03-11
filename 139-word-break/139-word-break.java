class Solution {
    // Set<String> dict;
    
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        cache = new Boolean[s.length()];

        return isValid(s, 0, new HashSet<>(wordDict));
    }
    
    private boolean isValid(String s, int startIdx, Set<String> dict) {
        if(startIdx == s.length()) {
            return true;
        }
        if (cache[startIdx] != null) return cache[startIdx];
        for(int start = startIdx+1; start <= s.length(); start++) {
            String subStr = s.substring(startIdx, start); // s.substring(3,4)
            // leet/code ,[leet, code]
            if(dict.contains(subStr) && isValid(s, start, dict)) { // subStr = t
                cache[startIdx] = true;
                return true;
            }
        }
        cache[startIdx] = false;
        return false;
    }
    
    
    
    
    
    
}