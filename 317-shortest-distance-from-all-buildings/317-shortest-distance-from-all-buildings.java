class Solution {
    
    private static int[][] DIRECTIONS = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    
    private int answer = Integer.MAX_VALUE;
    private int houseCount = 0;
    public int shortestDistance(int[][] grid) {
        //Naive Approach
        //traverse and
        // meet grid[i][j] = 0, start BFS
        //
        
        //1. get house count
        // steps, visited, houseReached
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        this.houseCount = getHouseCount(grid);
        if(houseCount == 0) return -1;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int currVal = grid[i][j];
                if(currVal == 0) {
                    bfsTraverse(i, j, grid);
                }
            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    private int getHouseCount(int[][] grid) {
        int houseCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) houseCount++;
            }
        }
        return houseCount;
    }
    
    private void bfsTraverse(int startY, int startX, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{startY, startX});
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int steps = 0;
        int distanceSum = 0;
        int houseReached = 0;
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int[] currPoint = q.poll();
                int currY = currPoint[0];
                int currX = currPoint[1];
                int cellValue = grid[currY][currX];
                if(cellValue == 1) {
                    distanceSum += steps;
                    houseReached++;
                    continue;
                }
                if(distanceSum > answer) return;
                if(houseReached == houseCount) break;
                
                    
                for(int[] direction : DIRECTIONS) {
                    int nextY = currY + direction[0];
                    int nextX = currX + direction[1];
                    if(nextY >= 0 && nextY < rows 
                      && nextX >= 0 && nextX < cols
                      && grid[nextY][nextX] != 2 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.add(new int[]{nextY, nextX});
                    }
                }
            }
            steps++;
        }
        if(houseReached < houseCount) 
            distanceSum = Integer.MAX_VALUE;
        answer = Math.min(distanceSum, answer);
        return;
    }
}