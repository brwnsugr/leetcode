class Solution {
    public String minWindow(String s, String t) {
        // A:0, B:0, C:0 required:3,   
        
        // S = "ABDC"E-> "AAAA"
        // 
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        int requiredCount = tMap.size();
        
        int r = 0;
        int l = 0;
        int formedCount = 0;
        int minLen = s.length() + 1;
        String res = "";
        while(r < s.length()) {
            char rightChar = s.charAt(r);
            boolean isFormed = false;
            if(tMap.containsKey(rightChar)) {
                tMap.put(rightChar, tMap.get(rightChar) - 1);
                if(tMap.get(rightChar) == 0) formedCount++;
            }
            
            while(l <= r && formedCount == requiredCount) {
                isFormed = true;
                char leftChar = s.charAt(l);
                if(tMap.containsKey(leftChar)) {
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                    if(tMap.get(leftChar) > 0) formedCount--;
                }
                l++;
            }
            if(r - l + 1 < minLen && isFormed) {
                res = s.substring(l-1, r+1); 
                minLen = r - l + 1;
            }
            r++;
        }
        
        return res;
    }
}