class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int l = 0;
        int r = 0;

        Map<Character, Integer> countMap = new HashMap<>();
        int maxLength = 0;
        while(r < s.length()) {
            countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);
            while(l < r && countMap.size() > 2) {
                countMap.put(s.charAt(l), countMap.get(s.charAt(l)) - 1);
                if(countMap.get(s.charAt(l)) == 0) countMap.remove(s.charAt(l));
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        } 
        return maxLength;
    }    
    
}