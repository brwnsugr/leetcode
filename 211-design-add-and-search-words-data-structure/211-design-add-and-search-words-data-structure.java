class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.next[c-'a'] == null) {
                curr.next[c-'a'] = new TrieNode();
            }
            curr = curr.next[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(curr, word, 0);
    }
    
    private boolean dfs(TrieNode curr, String word, int i) {
        if(i == word.length()) {
            return curr.isEnd;
        }
        else {
            if(word.charAt(i) == '.'){
                for(int j = 0; j < 26; j++) {
                    if(curr.next[j] != null) {
                        if(dfs(curr.next[j], word, i+1)) 
                            return true;
                    }
                }
                return false;
            } else {
                if(curr.next[word.charAt(i)-'a'] != null) {
                    return dfs(curr.next[word.charAt(i)-'a'], word, i+1);
                }
                return false;
            }
        }
    }
}

class TrieNode{
    public TrieNode[] next;
    public boolean isEnd;
    
    public TrieNode(){
        this.next = new TrieNode[26];
        this.isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */