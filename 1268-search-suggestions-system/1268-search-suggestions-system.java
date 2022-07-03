class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        
        for(String product : products) trie.insert(product);
        
        List<List<String>> answerList = new ArrayList<>();
        String prefix = "";
        
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> res = trie.getWordStartingWith(prefix);
            answerList.add(res);
        }
        
        return answerList;
    }
    
    
    
}


class Trie {
    
    public Node root;
    
    
    class Node {
        public boolean isWord;
        public Node[] children;
        
        public Node(){
            children = new Node[26];
        }
    }
    
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c-'a'] = new Node();
            }
            curr = curr.children[c-'a'];
        }
        
        curr.isWord = true;
    }
    
    private void dfsWithPrefix(Node curr, List<String> res, String word) {
        if(res.size() == 3) return;
        if(curr.isWord) res.add(word);
        
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null) {
                char c = (char)(i+'a');
                dfsWithPrefix(curr.children[i], res, word + c);
            }
        }
    }
    
    public List<String> getWordStartingWith(String prefix) {
        
        Node curr = root;
        List<String> res = new ArrayList<>();
        
        for(char c : prefix.toCharArray()) {
            if(curr.children[c-'a'] == null) return res;
            curr = curr.children[c-'a'];
        }
        
        dfsWithPrefix(curr, res, prefix);
        return res;
    }
    
    
}

