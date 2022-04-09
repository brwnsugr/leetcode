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
            // s1 = aaaaab, s2 = baaaaa kjlksjdksj
            c2[s2.charAt(l++)-'a']--;
            // l++;
            // r++;
            c2[s2.charAt(++r)-'a']++;
            
        }
        return false;
    }
    
    private boolean checkPermutation(String subStr) {
        int matchCount = 0;
        Set<Character> checked = new HashSet<>();
        for(int i = 0; i < subStr.length(); i++) {
            char currChar = subStr.charAt(i);
            if(c1[currChar - 'a'] != c2[currChar -'a']) return false;
            if(!checked.contains(currChar)) {
                matchCount += c1[currChar - 'a'];
                checked.add(currChar);
            }
            if(matchCount == subStr.length()) return true;
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