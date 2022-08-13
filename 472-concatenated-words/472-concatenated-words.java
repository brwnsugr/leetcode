class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       
        Set<String> wordDict = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for(String word : words) wordDict.add(word);
        
        for(String word : words) {
            if(isValid(word, wordDict)) answer.add(word);
        }
        
        return answer;
    }
    
    
    private boolean isValid(String word, Set<String> wordDict) {
        for(int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if(wordDict.contains(left) && (wordDict.contains(right) || isValid(right, wordDict))) {
                return true;
            }
        }
        return false;
    }
}