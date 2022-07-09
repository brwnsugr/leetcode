class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int answerCount = 0;
        
        for(String word : words) {
            if(isStretch(s, word)) answerCount++;
        }
        
        
        return answerCount;
    }
    
    private boolean isStretch(String S, String word){
        int i = 0;
        int j = 0;
        
        while( i < S.length()) {
            if(j < word.length() && S.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            }
            else {
                boolean threeConsecutive = false;
                
                threeConsecutive = ((i >= 1 && i< S.length() -1 && S.charAt(i -1) == S.charAt(i) && S.charAt(i) == S.charAt(i+1))
                                    ||(i >= 2 && S.charAt(i-2) == S.charAt(i-1) && S.charAt(i-1) == S.charAt(i)));
                
                if(!threeConsecutive) return false;
                else {
                    i++;
                }
            }
        }
        
        return j == word.length();
    }
}