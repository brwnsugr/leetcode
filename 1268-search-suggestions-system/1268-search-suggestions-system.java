class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /*
        1. Create a trie from the given products input
        2. 
    
        */
        Trie trie = new Trie();
        
        for(String product : products) {
            trie.insert(product);
        }
        
        String prefix = "";
        List<List<String>> answerList = new ArrayList<>();
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            answerList.add(trie.getWordStartingWith(prefix));
        }
        return answerList;
    }
    
    
}

class Trie {
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    }
    
    Node root; 
    Node curr;
    List<String> resultBuffer;
    
    void dfsWithPrefix(Node curr, String word) {
        if(resultBuffer.size() == 3) return;
        if(curr.isWord) resultBuffer.add(word);
        
        // for(char c = 'a'; c <= 'z'; c++) {
        //     if(curr.children.get(c-'a') != null) {
        //         dfsWithPrefix(curr.children.get(c-'a'), word + c);
        //     }
        // }
        for(int i = 0; i < 26; i++) {
            if(curr.children.get(i) != null) {
                char c = (char) (i+'a');
                dfsWithPrefix(curr.children.get(i), word+c);
            }
        }
    }
    
    Trie() {
        root = new Node();
    }
    
    //Insert the String into Trie
    void insert(String s) {
        curr = root;
        
        for(char c : s.toCharArray()) {
            if(curr.children.get(c-'a') == null) {
                curr.children.set(c-'a', new Node());
            }
            curr = curr.children.get(c-'a');
        }
        
        curr.isWord = true; // Mark that complete word as isWord true
    }
    
    List<String> getWordStartingWith(String prefix) {
        curr = root; // Starting from the root
        resultBuffer = new ArrayList<>();
        
        for(char c : prefix.toCharArray()) {
            if(curr.children.get(c-'a') == null) return resultBuffer;
            curr = curr.children.get(c-'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
    
};