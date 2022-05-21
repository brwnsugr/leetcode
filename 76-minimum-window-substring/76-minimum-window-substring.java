class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tDict = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            int count = tDict.getOrDefault(c, 0);
            tDict.put(c, count+1);
        }
        
        int formed = 0;
        
        int requiredChars = tDict.size();
        int[] ans = new int[]{-1,0,0};
        
        int l = 0;
        int r = 0;
        
        Map<Character, Integer> windowDict = new HashMap<>();
        while(r < s.length()) {
            char curr = s.charAt(r);
            
            int count = windowDict.getOrDefault(curr, 0);
            windowDict.put(curr, count + 1);
            
            if(tDict.containsKey(curr) && tDict.get(curr).intValue() == windowDict.get(curr).intValue()) {
                formed++;
            }
            
            while(l <= r && requiredChars == formed) {
                char leftChar = s.charAt(l);
                if(ans[0] == -1 || r-l+1 < ans[0]) ans = new int[]{r-l+1, l, r};
                
                windowDict.put(leftChar, windowDict.get(leftChar) - 1);
                
                if(tDict.containsKey(leftChar) && tDict.get(leftChar).intValue() > windowDict.get(leftChar).intValue()) {
                    formed--;
                }
                
                l++;
            }
            
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    
    }
}