class Solution {
/*
Using Trie.
N = length of products array, M = length of searchWord, K = length of longest product in products
TC: O(N*K) + O(M*K)
SC: O(K)

using trie
we store the each product of the product array to the tries and 
every prefix searchkeyword we trying to find 

n = length pr arr, m = len of searchword =, k = length of longest lenghth product

TC: O(k * n) + O(m * k)
SC: O(k)

TC: O(nlogn + m*logn)
SC: O()
*/
    
    
    
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Trie trie = new Trie();
        List<List<String>> answer = new ArrayList<>();
        
        for(String product : products) {
            trie.insert(product);
        }
        
        String prefix = "";
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> temp = trie.getWordStartingWith(prefix);
            answer.add(temp);
        }
        
        
        return answer;
        

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
        if(resultBuffer.size()==3) return;
        if(curr.isWord) resultBuffer.add(word);
        
        //Run DFS on all possible path
        for(char c = 'a'; c <= 'z'; c++) {
            if(curr.children.get(c-'a') != null) {
                
                dfsWithPrefix(curr.children.get(c-'a'), word + c);
            }
        }
        return;
    }
    
    Trie() {
        root = new Node();
    }
    
    //Insert the String into Trie
    void insert(String s) {
        curr = root;
        for(char c : s.toCharArray()) {
            // Node next = curr.children.get(c-'a');
            if(curr.children.get(c-'a') == null) {
                curr.children.set(c-'a', new Node());
            }
            curr = curr.children.get(c-'a');
        }
        curr.isWord = true;
    }
    
    List<String> getWordStartingWith(String prefix) {
        Node curr = root;
        resultBuffer = new ArrayList<>();
        for(char c : prefix.toCharArray()) {
            if(curr.children.get(c-'a') != null) {
                curr = curr.children.get(c-'a');
            }
            else {
                return resultBuffer;
            }
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
    
};