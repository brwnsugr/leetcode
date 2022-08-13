class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        
        for(String product : products) trie.insert(product);
        List<List<String>> answer = new ArrayList<>();
        
        String prefix = "";
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> res = new ArrayList<>();
            res = trie.getWordListWithPrefix(prefix);
            answer.add(res);
        }
        return answer;
    }
}

class Trie {
    
    class TrieNode {
        TrieNode[] childs;
        boolean isWord;
        SortedSet<String> words = new TreeSet<>();
        public TrieNode(){
            childs = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String input) {
        
        TrieNode curr = root;
        for(char c : input.toCharArray()) {
            if(curr.childs[c-'a'] == null) {
                curr.childs[c-'a'] = new TrieNode();
                
            }
            curr = curr.childs[c-'a']; 
        }
        curr.isWord = true;
    }
    
    public List<String> getWordListWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.childs[c-'a'] != null) {
                curr = curr.childs[c-'a'];
            }
            else {
                return res;
            }
        }

        dfs(curr, prefix, res);
        return res;
    }
    
    private void dfs(TrieNode curr, String word, List<String> res) {
        if(res.size() == 3) return;
        if(curr.isWord) res.add(word);
        
        for(int i = 0; i < 26; i++) {
            if(curr.childs[i] != null) {
                dfs(curr.childs[i], word + (char) (i + 'a'), res);
            }
        }
        return;
    }
    
//     public List<List<String>> getWordList(String searchWord) {
//         List<List<String>> res = new ArrayList<>();
//         TrieNode curr = root;
//         for(char c : searchWord.toCharArray()) {
//             List<String> tmp = new ArrayList<>();
//             if(curr.childs[c-'a'] == null) {
//                 res.add(tmp); 
//                 continue;
//             }
//             curr = curr.childs[c-'a'];
            
//             if(curr == null) res.add(tmp);
//             else{
//                 int cnt = 0;
//                 for(String key : curr.words) {
//                     tmp.add(key);
//                     cnt++;
//                     if(cnt == 3) break;
//                 }
//                 res.add(tmp);
//             }
//         }
        
//         return res;
//     }
}


