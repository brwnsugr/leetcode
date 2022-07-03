class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length == 1) return new ArrayList<>();
        List<String> answers = new ArrayList<>();
        Set<String> wordDict = new HashSet<>();
        
        for(String word : words) wordDict.add(word);
        
        for(String word : words) {
            if(isValid(word, wordDict)) answers.add(word);
        }
        
        return answers;
    }
    
    
    private boolean isValid(String word, Set<String> wordDict) {
        boolean[] dp = new boolean[word.length() + 1];
        
        dp[0] = true;
        int count = 0;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                
                if(dp[j] && wordDict.contains(word.substring(j, i)) && !word.substring(j,i).equals(word)) {
                    
                    dp[i] = true;
                    count++;
                }
            }
        }

        return count > 1 ? dp[word.length()] : false;    
    }
}