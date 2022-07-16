class Solution {
    
    private int rows;
    private int cols;
    private int answer;
    private static final int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0}
    };
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        
        obstacleGrid[0][0] = 1;
        for(int i = 1; i < rows; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }
        
        
        for(int i = 1; i < cols; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        }
        
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
                else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[rows-1][cols-1];
    }
    
    
}