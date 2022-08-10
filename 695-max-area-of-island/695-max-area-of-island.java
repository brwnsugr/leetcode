class Solution {
    private boolean[][] visited;
    private int steps;
    
    private final static int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    answer = Math.max(dfs(grid, i, j), answer);
                    steps = 0;
                }
            }
        }
        return answer;
    }
    
    
    private int dfs(int[][] grid, int currY, int currX) {
        grid[currY][currX] = 0;
        steps++;
        int height = grid.length;
        int width = grid[0].length;
        
        for(int[] direction : DIRECTIONS) {
            int nextY = currY + direction[0];
            int nextX = currX + direction[1];

            if(nextY >=0 && nextY < height
              && nextX >= 0 && nextX < width
              && grid[nextY][nextX] == 1) {
                dfs(grid, nextY, nextX);
            }
        }
        return steps;
    }
}