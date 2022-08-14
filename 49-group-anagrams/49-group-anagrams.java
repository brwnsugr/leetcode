class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        for(String str : strs) {
            String key = buildKey(str);
            
            if(!anaMap.containsKey(key)) anaMap.put(key, new ArrayList<>());
            anaMap.get(key).add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : anaMap.entrySet()) {
            answer.add(entry.getValue());
        }
        return answer;
    }
    
    private String buildKey(String input) {
        int[] counts = new int[26];
        
        for(char c : input.toCharArray()) {
            counts[c-'a']++;
        }
        
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            if(counts[i] > 0) {
                char c = (char)(i + 'a');
                strBuilder.append(c);
                strBuilder.append(counts[i]);
            }
        }
        
        return new String(strBuilder);
    }
}