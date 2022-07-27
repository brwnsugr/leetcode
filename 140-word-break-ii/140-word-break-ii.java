class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
            
        }

        List<List<String>> dp = new ArrayList<>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; ++i) {
            ArrayList<String> emptyList = new ArrayList<String>();
            dp.add(emptyList);
        }
        dp.get(0).add("");

        for (int endIndex = 1; endIndex < s.length() + 1; ++endIndex) {
            List<String> subList = new ArrayList<>();
            
            for(int startIdx = 0; startIdx < endIndex; startIdx++) {
                String word = s.substring(startIdx, endIndex);
                
                if(wordSet.contains(word)) {
                    List<String> dpList = dp.get(startIdx);
                    for(String subWord : dpList) {
                        subList.add((subWord + " " + word).strip());
                    }
                    
                }
            }
            dp.set(endIndex, subList);
        }

        return dp.get(s.length());
    }
}