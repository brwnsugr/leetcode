class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        Map<String, Integer> wordMap = new HashMap<>();
        //build up wordSet
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(!wordMap.containsKey(word)) 
                wordMap.put(word, i);
        }

        // abcdabc
        
        // dcbabcd
        // banan(a)nanab  
        // ban(ana)nab   -> prefixMatch = ["ban"->reverse, "banan"->r, "b"->r]
        // anana(b)anana -> suffixMatch = ["anana" -> r]
        // ananab
        List<List<Integer>> answers = new ArrayList<>();
        
        for(String currWord : wordMap.keySet()) {
            //1. check if there exists reverse word
            int currIdx = wordMap.get(currWord);
            
            String reversedWord = new StringBuilder(currWord).reverse().toString();
            
            if(wordMap.containsKey(reversedWord) && wordMap.get(reversedWord) != currIdx) {
                int reverseWordIdx = wordMap.get(reversedWord);
                answers.add(Arrays.asList(currIdx, reverseWordIdx));
            }
            
            List<String> prefixPalindromeList = getPrefixPalindromeList(currWord);
            for(String prefix : prefixPalindromeList) {
                if(wordMap.containsKey(prefix)) {
                    answers.add(Arrays.asList(currIdx, wordMap.get(prefix)));
                }
            }
            
            List<String> suffixPalindromeList = getSuffixPalindromeList(currWord);
            for(String suffix : suffixPalindromeList) {
                if(wordMap.containsKey(suffix)) {
                    answers.add(Arrays.asList(wordMap.get(suffix), currIdx));
                }
            }
            
        }
        
        
        return answers;
        
    }
    
    private List<String> getSuffixPalindromeList(String word) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            if(isPalindrome(0, i, word)) {
                String palinedromeWord = new StringBuilder(word.substring(i+1)).reverse().toString();
                res.add(palinedromeWord);
            }
        }
        return res;
    }
    
    private List<String> getPrefixPalindromeList(String word) {
        List<String> res = new ArrayList<>();
        String reversedWord = new StringBuilder(word).reverse().toString();
        for(int i = 0; i < reversedWord.length(); i++) {
            if(isPalindrome(0, i, reversedWord)) {
                res.add(reversedWord.substring(i+1));
            }
        }
        return res;
    }
    
    private boolean isPalindrome(int start, int end, String word) {
        while(start < end) {
            if(word.charAt(start++) != word.charAt(end--)) return false;
        }
        
        return true;
    }
    
    
}