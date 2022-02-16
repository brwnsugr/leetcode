class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        /*
        [cat, cats, catsdogscats, dog, dogcatsdog, rat, ratcatdogcat]
        [cat, dog, rat, cats, catsdogscats, dogcatsdog, ratcatdogcat]
        */
        if(words.length == 1) return new ArrayList<>();
        
        List<String> answers = new ArrayList<>();
        Set<String> wordDict = new HashSet<>();
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        
        for(String word : words) {
            if(isValid(word, wordDict)) answers.add(word);
            wordDict.add(word);
        }
        
        return answers;
    }
    
    private boolean isValid(String word, Set<String> wordDict) {
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        //    ^  ^
        //   "abcabc"
        //     
        //dp=[1001001]
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