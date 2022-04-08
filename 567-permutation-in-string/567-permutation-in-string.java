class Solution {
    int[] c1 = new int[26];
    int[] c2 = new int[26];
    public boolean checkInclusion(String s1, String s2) {
        // eidba
        // a:1, b:1 -> 
        // 
        if(s1.length() > s2.length()) return false;
        int s1Len = s1.length();
        String firstStr = s2.substring(0,s1Len);
        int l = 0; 
        int r = s1Len-1;
        fillCharArr(firstStr, s1);
        
        
        while (r < s2.length()) {
            if(checkPermutation(s2.substring(l, r+1))) return true;
            if(r == s2.length() - 1) break;
            
            c2[s2.charAt(l++)-'a']--;
            // l++;
            // r++;
            c2[s2.charAt(++r)-'a']++;
            
        }
        return false;
    }
    
    private boolean checkPermutation(String subStr) {
        for(int i = 0; i < subStr.length(); i++) {
            if(c1[subStr.charAt(i) - 'a'] != c2[subStr.charAt(i) -'a']) return false;
        }
        return true;
    }
    
    private void fillCharArr(String firstStr, String s1) {
        for(int i = 0; i < firstStr.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[firstStr.charAt(i) - 'a']++;
        }
    }
}