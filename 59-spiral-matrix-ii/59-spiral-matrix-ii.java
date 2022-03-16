class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] board = new int[n][n];
        int totalCount = n*n;
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        
        int count = 0;
        while(true) {
            //right
            for(int col = left; col <= right; col++) {
                board[up][col] = ++count;
            }
            up++;
            if(count >= totalCount) break;
            //down
            for(int row = up; row <= down; row++) {
                board[row][right] = ++count;
            }
            right--;
            if(count >= totalCount) break;
            
            //left
            for(int col = right; col >= left; col--) {
                board[down][col] = ++count;
            }
            down--;
            if(count >= totalCount) break;
            
            //up
            for(int row = down; row >= up; row--) {
                board[row][left] = ++count;
            }
            left++;
            if(count >= totalCount) break;
        }
        
        return board;
    }
}