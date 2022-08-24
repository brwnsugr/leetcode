class Solution {
    public int lengthOfLongestSubstring(String s) {
        // a(bca)bc,   a: 0, b: 1, c: 2, a: 3
        // pw(wke)w , p:0, w:2, k:, if we reach out to the exsiting char, update latest pos to (prevpos, leftMost)
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Integer> positionMap = new HashMap<>();
        // for(char c : s.toCharArray()) countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        int l = -1;
        int r = 0;
        int answer = 0;
        
        for(r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            if(!positionMap.containsKey(currChar)) {
                positionMap.put(currChar, r);
            }
            else {
                int prevPosition = positionMap.get(currChar);
                l = Math.max(prevPosition, l);
                positionMap.put(currChar, r);
            }
            answer = Math.max(r - l, answer);
        }
        return answer;
    }
}