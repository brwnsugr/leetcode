class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> originCharMap = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            if(!originCharMap.containsKey(c)) originCharMap.put(c, 0);
            originCharMap.put(c, originCharMap.get(c) + 1);
        }
        
        
        Map<Character, Integer> windowMap = new HashMap<>();
        int r = 0;
        int l = 0;
        int[] windowBoundary = new int[]{0,0};
        int minWidth = Integer.MAX_VALUE;
        String res = "";
        
        while(r < s.length()) {
            //
            char curr = s.charAt(r);
            
            if(!windowMap.containsKey(curr)) windowMap.put(curr, 0);
            windowMap.put(curr, windowMap.get(curr) + 1);
            boolean isFormed = false;
            while(l <= r && formed(originCharMap, windowMap)) {
                char leftChar = s.charAt(l);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                l++;
                isFormed = true;
            }
            
            if(isFormed && r - l < minWidth) {
                minWidth = r - l;
                res = s.substring(l - 1, r + 1);
            }
            
            r++;
        }
        
        
        
        return res; 
    }
    
    
    private boolean formed(Map<Character, Integer> originMap, Map<Character, Integer> windowMap ) {
        for(Map.Entry<Character, Integer> entry : originMap.entrySet()) {
            if(!windowMap.containsKey(entry.getKey()) || windowMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}