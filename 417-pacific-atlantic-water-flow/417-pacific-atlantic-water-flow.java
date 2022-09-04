class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        numRows = heights.length;
        numCols = heights[0].length;
        if(numRows == 0 || numCols == 0) return new ArrayList<>();
        landHeights = heights;
        boolean[][] pacificVisited = new boolean[numRows][numCols];
        boolean[][] atlanticVisited = new boolean[numRows][numCols];
        
        //init pacific queue
        for(int col = 0; col < numCols; col++) {
            dfs(0, col, pacificVisited);
            dfs(numRows - 1, col, atlanticVisited);
        }
        
        //init atlantic queue
        for(int row = 0; row < numRows; row++) {
            dfs(row, 0, pacificVisited);
            dfs(row, numCols - 1, atlanticVisited);
        }
        

        List<List<Integer>> res = new ArrayList<>();
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                if(pacificVisited[row][col] && atlanticVisited[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int currRow, int currCol, boolean[][] visited) {
        if(visited[currRow][currCol]) return;
        visited[currRow][currCol] = true;
        
        for(int[] direction : DIRECTIONS) {
            int nextY = currRow + direction[0];
            int nextX = currCol + direction[1];
            if(nextY >= 0 && nextY < numRows
              && nextX >= 0 && nextX < numCols
              && !visited[nextY][nextX]
              && landHeights[nextY][nextX] >= landHeights[currRow][currCol]) {
                dfs(nextY, nextX, visited);
            }
        }
    }
}