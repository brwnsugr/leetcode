class WordDictionary {
    
    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        char[] charArr = word.toCharArray();
        Node curr = root;
        for(char c : charArr) {
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new Node();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        return dfs(curr, 0, word);
    }
    
    private boolean dfs(Node curr, int idx, String word) {
        for(int i = idx; i < word.length(); i++) {
            char currCh = word.charAt(i);
            
            if(currCh == '.') {
                for(Node node : curr.children) {
                    if(node != null && dfs(node, i+1, word)) {
                        return true;
                    }
                }
                
                return false;
            }
            
            if(curr.children[currCh-'a'] == null) return false;
            
            curr = curr.children[currCh -'a'];
            
        }
        
        return curr.isWord;
    }
}

class Node {
    Node[] children;
    boolean isWord;
    
    public Node() {
        children = new Node[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */