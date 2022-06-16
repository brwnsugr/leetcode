class Solution {
    
    private TrieNode root;
    private List<String> answers;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        answers = new ArrayList<>();
        // insert word to Trie DS
        for(String word : words) {
            insertWord(word);
        }
        // backtracking in word grid til we find the path forms the complete word from the trie that we built
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(root.children.containsKey(board[i][j]))
                    backTracking(board, root, i, j);
            }
        }
        
        return answers;
        
    }
    
    private void backTracking(char[][] board, TrieNode parent, int curRow, int curCol){
        TrieNode currNode = parent.children.get(board[curRow][curCol]);
        if(currNode.word != null) {
            answers.add(currNode.word);
            currNode.word = null; // mark it as null to avoid the duplicated ones
        }
        
        char currCh = board[curRow][curCol];
        
        int[] nextRows = new int[]{1,-1,0,0};
        int[] nextCols = new int[]{0,0,1,-1};
        
        board[curRow][curCol] = '#'; // for backtracking
        for(int i = 0; i < 4; i++) {
            int nextRow = curRow + nextRows[i];
            int nextCol = curCol + nextCols[i];
            if(nextRow >= 0 && nextRow < board.length
              && nextCol >= 0 && nextCol < board[0].length
              && currNode.children.containsKey(board[nextRow][nextCol])) {
                backTracking(board, currNode, nextRow, nextCol);
            }
        }
        board[curRow][curCol] = currCh;
        
        if(currNode.children.isEmpty()) {
            parent.children.remove(currCh);
        }
        
    }
    
    
    private void insertWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = word;
    }
}


class TrieNode{
    public Map<Character, TrieNode> children = new HashMap<>();
    public String word;
    public TrieNode(){
        
    }
}