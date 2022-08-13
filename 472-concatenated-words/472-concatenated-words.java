class Solution {
    
    private Set<String> cache = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordDict = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for(String word : words) wordDict.add(word);
        
        for(String word : words) {
            if(isValid(word, wordDict)) answer.add(word);
            cache = new HashSet<>();
        }
        
        return answer;
    }
    
    
    private boolean isValid(String word, Set<String> wordDict) {
        if(cache.contains(word)) return true;
        for(int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if(wordDict.contains(left) && (wordDict.contains(right) || isValid(right, wordDict))) {
                cache.add(right);
                return true;
            }
        }
        return false;
    }
}