class Solution {
    
    static final int[][] DIRECTIONS = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    }; 
    
    private boolean visited[][];
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // visited = new boolean[rows][cols];
        
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] board = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
                else {
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int[] direction : DIRECTIONS) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                if(nextRow < rows && nextRow >= 0
                  && nextCol < cols && nextCol >= 0
                  && board[nextRow][nextCol] > board[currRow][currCol] + 1) {
                    board[nextRow][nextCol] = board[currRow][currCol] + 1;
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }
        
        return board;
    }
}