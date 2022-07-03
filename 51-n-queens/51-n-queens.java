class Solution {
    
    private List<List<String>> answerList;
    public List<List<String>> solveNQueens(int n) {
        
        Set<Integer> leftDownDiagonal = new HashSet<>();
        Set<Integer> rightDownDiagonal = new HashSet<>();
        Set<Integer> visitedCol = new HashSet<>();
        answerList = new ArrayList<>();
        
        char[][] board = new char[n][n];
        //init board with . 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backTrack(0, n, leftDownDiagonal, rightDownDiagonal, visitedCol, board);
        
        return answerList;
        
    }
    
    
    private void backTrack(int row, int n, Set<Integer> leftDownDiagonal, Set<Integer> rightDownDiagonal, Set<Integer> visitedCol, char[][] board) {
        if(row == n) {
            appendToAnswer(board);
            return;
        }
        
        for(int col = 0; col < n; col++) {
            if(!leftDownDiagonal.contains(row + col)
              &&!rightDownDiagonal.contains(row - col)
              &&!visitedCol.contains(col)) {
                leftDownDiagonal.add(row+col);
                rightDownDiagonal.add(row-col);
                visitedCol.add(col);
                board[row][col] = 'Q';
                backTrack(row+1, n, leftDownDiagonal, rightDownDiagonal, visitedCol, board);
                leftDownDiagonal.remove(row+col);
                rightDownDiagonal.remove(row-col);
                visitedCol.remove(col);
                board[row][col] = '.';
            }
        }
        
    }
    
    
    private void appendToAnswer(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for(int j = 0; j < board[i].length; j++) {
                strBuilder.append(board[i][j]);
            }
            res.add(new String(strBuilder));
        }
        
        answerList.add(res);
    }
}