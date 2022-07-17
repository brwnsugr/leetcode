class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> anaMap = new HashMap<>();
        
        int[] countArr = new int[26];
        
        for(String s : strs) {
            Arrays.fill(countArr, 0);
            for(char c : s.toCharArray()) countArr[c-'a']++;
            
            StringBuilder strBuilder = new StringBuilder();
            
            for(int i = 0; i < 26; i++) {
                strBuilder.append('#');
                strBuilder.append(countArr[i]);
            }
            
            String key = strBuilder.toString();
            if(!anaMap.containsKey(key)) anaMap.put(key, new ArrayList<>());
            anaMap.get(key).add(s);
        }
        
        return new ArrayList<>(anaMap.values());
    }
}