class Solution {
    
    List<List<String>> answers = new ArrayList<>();
    
    
    
    public List<List<String>> solveNQueens(int n) {
        //
        
        
        // 1st row : Q 2nd. 
        // 2nd r: Q 4th
        // 3Rd: Q:1st, 
        // 4th : Q 3rd
        // N = length of one side length of board, O(N^2)
        // SC: O(N^2) 
        char[][] state = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) state[i][j] = '.';
        }
        Set<Integer> leftDownDiagonal = new HashSet<>();
        Set<Integer> rightDownDiagonal = new HashSet<>();
        Set<Integer> visitedCol = new HashSet<>();
        
        
        
        traverse(leftDownDiagonal, rightDownDiagonal, visitedCol, 0, n, state);
            
        
        
        return answers;
    }
    
    
    private void traverse(Set<Integer> leftDownDiagonal, Set<Integer> rightDownDiagonal, Set<Integer> visitedCol, int row, int n, char[][] state) {
        if(row == n) {
            appendToAnswer(state);
            return;
        }
        
        for(int col = 0; col < n; col++) {
            
            
            if(!leftDownDiagonal.contains(row+col) 
               && !rightDownDiagonal.contains(row-col) 
               && !visitedCol.contains(col)) {
                leftDownDiagonal.add(row+col);
                rightDownDiagonal.add(row-col);
                visitedCol.add(col);
                state[row][col] = 'Q';
                traverse(leftDownDiagonal, rightDownDiagonal, visitedCol, row+1, n, state);
                leftDownDiagonal.remove(row+col);
                rightDownDiagonal.remove(row-col);
                visitedCol.remove(col);
                state[row][col] = '.';
            }
        }
    }
    
    private void appendToAnswer(char[][] state) {
        List<String> answer = new ArrayList<>();
        int rows = state.length;
        for(int i = 0; i < rows; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for(int j = 0; j < rows; j++) {
                strBuilder.append(state[i][j]);
            }
            answer.add(strBuilder.toString());
        }
        answers.add(answer);
    }
    
    
    
    
}