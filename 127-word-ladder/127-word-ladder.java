class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //bfs
        Set<String> wordDict = new HashSet<>(wordList);
        if(!wordDict.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        
        q.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()) {
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++) {
                char[] curr = q.poll().toCharArray();
                
                for(int j = 0; j < curr.length; j++) {
                    char tmp = curr[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        curr[j] = c;
                        String mutatedWord = new String(curr);
                        if(mutatedWord.equals(endWord)) return steps + 1;
                        if(wordDict.contains(mutatedWord)) {
                            q.add(mutatedWord);
                            wordDict.remove(mutatedWord);
                        }
                    }
                    curr[j] = tmp;
                }
            }
            steps++;
        }
        return 0;
    }
    
    // private boolean isAdjacent(String word1, String word2) {
    //     if(Math.abs(word1.length() - word2.length()) > 1) return false;
    //     else if(Math.abs(word1.length() - word2.length() == 1)) {
    //         int min = Math.min(word1.length(), word2.length());
    //         for(int i = 0; i < min; i++) {
    //             if(word1.get(i) != word2.get(i)) return false;
    //         }
    //         return true;
    //     }
    //     else {
    //         int diffCount = 0;
    //         for(int i = 0; i < word1.size(); i++) {
    //             if(word1.get(i) != word2.get(i)) diffCount++;
    //             if(diffCount > 1) return false;
    //         }
    //         return diffCount == 1; 
    //     }
    // }
}