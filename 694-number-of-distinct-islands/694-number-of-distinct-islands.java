class Solution {
    private List<List<int[]>> uniqueIslands = new ArrayList<>();
    private List<int[]> currentIsland = new ArrayList<>();
    private int[][] grid;
    private boolean[][] visited;
    private static final int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    public int numDistinctIslands(int[][] grid) {
        
        
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                dfs(row, col);
                if(currentIsland.isEmpty()) continue;
                
                int minCol = grid[0].length - 1;
                for(int i = 0; i < currentIsland.size(); i++) {
                    minCol = Math.min(minCol, currentIsland.get(i)[1]);
                }
                
                for(int[] cell : currentIsland) {
                    cell[0] -= row;
                    cell[1] -= minCol;
                }
                
                if(currentIslandUnique()) {
                    uniqueIslands.add(currentIsland);
                }
                currentIsland = new ArrayList<>();
            }
        }
        // 1 
        // 
        //
        return uniqueIslands.size();
    }
    
    
    private void dfs(int row, int col) {
        if(visited[row][col] || grid[row][col] == 0) return;
        
        visited[row][col] = true;
        currentIsland.add(new int[]{row, col});
        
        for(int[] direction : DIRECTIONS) {
            int nextY = row + direction[0];
            int nextX = col + direction[1];
            if(nextY >= 0 && nextY < grid.length
              && nextX >= 0 && nextX < grid[0].length
              && !visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        } 
    }
    
    private boolean currentIslandUnique(){
        for(List<int[]> otherIsland : uniqueIslands) {
            if(currentIsland.size() != otherIsland.size()) continue;
            if(equalIslands(currentIsland, otherIsland)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean equalIslands(List<int[]> island1, List<int[]> island2) {
        for(int i = 0; i < island1.size(); i++) {
            if(island1.get(i)[0] != island2.get(i)[0] || island1.get(i)[1] != island2.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}