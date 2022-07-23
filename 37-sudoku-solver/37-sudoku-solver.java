class Solution {
    private int n = 3;
    
    private int N = n * n;
    private char[][] board;
    private boolean solved = false;
    
    private int[][] rows = new int[N][N+1];
    private int[][] cols = new int[N][N+1];
    private int[][] boxes = new int[N][N+1];
    
    private void placeNumber(int d, int row, int col) {
        int boxIdx = (row / n) * n + col / n;
        rows[row][d]++;
        cols[col][d]++;
        boxes[boxIdx][d]++;
        board[row][col] = (char)(d + '0');
    }
    
    private void removeNumber(int d, int row, int col) {
        int boxIdx = (row / n) * n + col / n;
        rows[row][d]--;
        cols[col][d]--;
        boxes[boxIdx][d]--;
        board[row][col] = '.';
    }
    
    private void placeNext(int row, int col) {
        
        if(row == N-1 && col == N-1) {
            solved = true;
        }
        else {
            if(col == N-1) backTrack(row+1, 0);
            else backTrack(row, col + 1);
        }
    }
    
    private void backTrack(int row, int col) {
        if(board[row][col] == '.') {
            for(int i = 1; i <= 9; i++) {
                if(canPlace(i, row, col)) {
                    placeNumber(i, row, col);
                    placeNext(row, col);
                    if(!solved) removeNumber(i, row, col);
                }
            }
        }
        else placeNext(row, col);
    }
    
    
    
    private boolean canPlace(int d, int row, int col) {
        int boxIdx = (row / n) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[boxIdx][d] == 0;
    }
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                char num = board[i][j];
                if(num != '.') {
                    int d =(int)(num - '0');
                    placeNumber(d, i, j);
                }
            }
        }
        
        backTrack(0,0);
    }
}