class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       
        Set<String> wordDict = new HashSet<>();
        List<String> answer = new ArrayList<>();
        // for(String word : words) 
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        for(String word : words) {
            if(isValid(word, wordDict)) answer.add(word);
            wordDict.add(word);
        }
        
        return answer;
    }
    
    
    private boolean isValid(String word, Set<String> wordDict) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        int count = 0;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(word.substring(j, i))) {
                    count++;
                    dp[i] = true;
                }
            }
        }
                   
        return count > 1 ? dp[word.length()] : false;
    }
}