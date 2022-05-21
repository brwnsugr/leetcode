class Solution {
    public int firstUniqChar(String s) {
        // 
        //twoTimes = [e]
        
        Set<Character> twoTimes = new HashSet<>();
        
        int[] counts = new int[26];
        for(char c : s.toCharArray()) {
            counts[c-'a']++;
            if(counts[c-'a'] > 1) twoTimes.add(c);
        }
        
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(counts[curr-'a'] == 1) return i;
        }
        
        return -1;
    }
}