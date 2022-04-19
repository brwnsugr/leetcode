class Solution {
    public int minPathSum(int[][] grid) {
        // dp[m][n]: minimum Sum at (m,n)
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        
        // dp[i+1][j+1] = min (dp[i][j+1] , dp[i+1][j]) + grid[i+1][j+1]
        // set init value dp[0][0] = grid[0][0]
        dp[0][0] = grid[0][0];
        
        // 
        for(int i = 0; i < rows -1; i++) {
            dp[i+1][0] = dp[i][0] + grid[i+1][0];
        }
        
        for(int i = 0; i < cols - 1; i++) {
            dp[0][i+1] = dp[0][i] + grid[0][i+1];
        }
        
        
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        
        
        return dp[rows-1][cols-1];
        
    }
}