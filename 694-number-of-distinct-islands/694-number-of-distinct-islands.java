class Solution {
    private List<List<int[]>> uniqueIslands = new ArrayList<>();
    // private List<int[]> currentIsland = new ArrayList<>();
    private Set<Pair<Integer, Integer>> currentIsland;
    private int[][] grid;
    private boolean[][] visited;
    private static final int[][] DIRECTIONS = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    public int numDistinctIslands(int[][] grid) {
        
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                this.currentIsland = new HashSet<>();
                dfs(row, col, row, col);
                if(currentIsland.isEmpty()) continue;
                if(!currentIsland.isEmpty()) islands.add(currentIsland);
            }
        }
        return islands.size();
    }
    
    
    private void dfs(int row, int col, int startRow, int startCol) {
        if(visited[row][col] || grid[row][col] == 0) return;
        
        visited[row][col] = true;
        currentIsland.add(new Pair<>(row - startRow, col - startCol));
        
        for(int[] direction : DIRECTIONS) {
            int nextY = row + direction[0];
            int nextX = col + direction[1];
            if(nextY >= 0 && nextY < grid.length
              && nextX >= 0 && nextX < grid[0].length
              && !visited[nextY][nextX]) {
                dfs(nextY, nextX, startRow, startCol);
            }
        } 
    }
    

}