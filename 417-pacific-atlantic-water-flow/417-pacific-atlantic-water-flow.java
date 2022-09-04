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
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        //init pacific queue
        for(int col = 0; col < numCols; col++) {
            pacificQueue.add(new int[]{0, col});
            atlanticQueue.add(new int[]{numRows - 1, col});
        }
        
        //init atlantic queue
        for(int row = 0; row < numRows; row++) {
            pacificQueue.add(new int[]{row, 0});
            atlanticQueue.add(new int[]{row, numCols - 1});
        }
        
        boolean[][] pacificReached = bfs(pacificQueue);
        boolean[][] atlanticReached = bfs(atlanticQueue);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                if(pacificReached[row][col] && atlanticReached[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }
        
        return res;
    }
    
    private boolean[][] bfs(Queue<int[]> q) {
        boolean[][] visited = new boolean[numRows][numCols];
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            visited[curr[0]][curr[1]] = true;
            
            for(int[] direction : DIRECTIONS) {
                int nextY = curr[0] + direction[0];
                int nextX = curr[1] + direction[1];
                
                if(nextY >= 0 && nextY < numRows
                  && nextX >= 0 && nextX < numCols
                  && !visited[nextY][nextX]
                  && landHeights[nextY][nextX] >= landHeights[curr[0]][curr[1]]) {
                    q.add(new int[]{nextY, nextX});
                }
            }
        }
        return visited;
    }
}