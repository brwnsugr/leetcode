class Solution {
    
    private int rows; 
    private int cols;
    private int[][] grid;
    private int answer;
    
    private final static int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        int emptyCells = 0;
        rows = grid.length; 
        cols = grid[0].length;
        
        int startRow = 0;
        int startCol = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int cell = grid[i][j];
                
                if(cell >= 0) emptyCells++;
                if(cell == 1) {
                    startRow = i;
                    startCol = j;
                } 
            }
        }
        
        backTrack(startRow, startCol, emptyCells);
        
        return answer;
    }
    
    
    private void backTrack(int currRow, int currCol, int remain) {
        int currCell = grid[currRow][currCol];

        if(currCell == 2 && remain == 1) {
            answer++;
            return;
        }
        
        grid[currRow][currCol] = -4;
        remain--;
        for(int[] direction : DIRECTIONS) {
            int nextRow = currRow + direction[0];
            int nextCol = currCol + direction[1];
            if(nextRow >= 0 && nextRow < rows
              && nextCol >= 0 && nextCol < cols
              && grid[nextRow][nextCol] >= 0) {
                backTrack(nextRow, nextCol, remain);
            }
        }
        
        // remain++;
        grid[currRow][currCol] = currCell;
    }
}