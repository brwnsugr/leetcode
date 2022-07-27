class Solution {
    public int longestRepeatingSubstring(String s) {
        int l = 1;
        int r = s.length();
        
        
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(search(mid, s) != -1) l = mid+1;
            else r = mid - 1;
        }
        
        return l - 1;
    }
    
    
    private int search(int L, String s) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < s.length() - L + 1; i++) {
            String temp = s.substring(i, i+L);
            if(seen.contains(temp)) return i;
            seen.add(temp);
        }
        return -1;
    }
    
    
}