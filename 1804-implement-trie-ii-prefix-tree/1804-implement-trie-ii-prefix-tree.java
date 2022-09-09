class Trie {
    
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        
        if(word == null || word.equals("")) return;
        char[] charArr = word.toCharArray();
        for(char c : charArr) {
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new Node();
            curr = curr.children[c-'a'];
            curr.prefixCount++;
        }
        curr.endCount++;
        curr.isWord = true;
    }
    
    public int countWordsEqualTo(String word) {
        if(word == null || word.equals("")) return 0;
        Node curr = root;
        char[] charArr = word.toCharArray();
        for(char c : charArr) {
            if(curr.children[c-'a'] == null) return 0;
            else curr = curr.children[c-'a'];
        }
        
        return curr.isWord ? curr.endCount : 0;
    }
    
    public int countWordsStartingWith(String prefix) {
        if(prefix == null || prefix.equals("")) return 0;
        Node curr = root;
        char[] charArr =prefix.toCharArray();
        
        for(char c : charArr) {
            if(curr.children[c-'a'] == null) return 0;
            else curr = curr.children[c-'a'];
        }
        
        return curr.prefixCount;
    }
    
    public void erase(String word) {
        if(word == null || word.equals("")) return;
        Node curr = root;
        char[] charArr = word.toCharArray();
        
        for(char c : charArr) {
            curr.children[c-'a'].prefixCount--;
            if(curr.children[c-'a'].prefixCount < 1) {
                curr.children[c-'a'] = null;
                return;
            } else {
                curr = curr.children[c-'a'];
            }
        }
        curr.endCount--;
    }
}

class Node {
    Node[] children;
    boolean isWord;
    int prefixCount;
    int endCount;
    
    public Node(){
        children = new Node[26];
        isWord = false;
        prefixCount = 0;
        endCount = 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */