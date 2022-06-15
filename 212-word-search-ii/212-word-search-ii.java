class Solution {
    
    private TrieNode root;
    private List<String> answers;
    private static int[][] DIRECTIONS = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        
        for(String word : words) {
            insertWord(word);
        }
        
        answers = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(root.children.containsKey(board[i][j]))
                    backTrack(board, i, j, root);
            }
        }
        
        return answers;
    }
    
    private void backTrack(char[][] board, int currRow, int currCol, TrieNode parent) {
        char currCh = board[currRow][currCol];
        TrieNode currNode = parent.children.get(currCh);
        
        if(currNode != null && currNode.word != null) {
            answers.add(currNode.word);
            currNode.word = null;
        }
        
        board[currRow][currCol] = '#';
        
        for(int[] direction : DIRECTIONS) {
            int nextRow = currRow + direction[0];
            int nextCol = currCol + direction[1];
            if(nextRow < board.length && nextRow >= 0
              && nextCol < board[0].length && nextCol >= 0
              && currNode != null) {
                if(currNode.children.containsKey(board[nextRow][nextCol]))
                    backTrack(board, nextRow, nextCol, currNode);
            }
        }
        
        board[currRow][currCol] = currCh;
        
        if(currNode.children.isEmpty()) {
            parent.children.remove(currCh);
        }
        
    }
    
    private void insertWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char currCh = word.charAt(i);
            if(!curr.children.containsKey(currCh)) curr.children.put(currCh, new TrieNode());
            curr = curr.children.get(currCh);
        }
        curr.word = word;
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode(){
        
    }
}