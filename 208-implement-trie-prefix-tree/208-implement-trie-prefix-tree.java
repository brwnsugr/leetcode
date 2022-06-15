class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.next[c-'a'] ==null) curr.next[c-'a'] = new TrieNode();
            curr = curr.next[c-'a'];
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.next[c-'a'] == null) return false;
            else {
                curr = curr.next[c-'a'];
            }
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.next[c-'a'] == null) return false;
            curr = curr.next[c-'a'];
        }
        return true;
    }
}

class TrieNode {
    public TrieNode[] next;
    public boolean isEnd;
    
    public TrieNode() {
        this.next = new TrieNode[26];
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */