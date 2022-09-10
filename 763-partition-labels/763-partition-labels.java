class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            posMap.put(s.charAt(i), i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        int r = 0;
        int l = 0;
        int tempLen = 0;
        while(l < s.length()) {
            r = Math.max(r, posMap.get(s.charAt(l)));
            tempLen = 0;
            while(l <= r) {
                r = Math.max(r, posMap.get(s.charAt(l)));
                tempLen++;
                l++;
            }
            res.add(tempLen);
        }
        return res;
    }
}