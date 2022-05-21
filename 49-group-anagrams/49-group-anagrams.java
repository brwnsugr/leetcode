class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // abca, aabc -> aabc
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str : strs) {
            StringBuilder strBuilder = new StringBuilder();
            int[] charCount = new int[26];
            for(char c : str.toCharArray()) {
                charCount[c-'a']++;
            }
            
            for(int i = 0; i < charCount.length; i++) {
                while(charCount[i] > 0) {
                    strBuilder.append(i+'a');
                    charCount[i]--;
                }
            }
            String anagramKey = new String(strBuilder);
            if(!groupMap.containsKey(anagramKey)) {
                groupMap.put(anagramKey, new ArrayList<>());
            }
            groupMap.get(anagramKey).add(str);
        }
        
        List<List<String>> answers = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
            answers.add(entry.getValue());
        }
        
        return answers;
    }
}