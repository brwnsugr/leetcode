class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answers = new ArrayList<>();
        Map<String, List<String>> anaMap = new HashMap<>();
        
        for(String word : strs) {
            String key = makeKey(word);
            if(!anaMap.containsKey(key)) anaMap.put(key, new ArrayList<>());
            anaMap.get(key).add(word);
        }
        
        for(Map.Entry<String, List<String>> entry : anaMap.entrySet()) {
            answers.add(entry.getValue()); 
        }
        
        return answers;
    }
    
    
    private String makeKey(String word) {
        int[] counts = new int[26];
        for(char c : word.toCharArray()) {
            counts[c-'a']++;
        }
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] > 0) {
                char c = (char) (i + 'a');
                strBuilder.append(c).append(counts[i]);
            }
        }
        return new String(strBuilder);
    }
}