class Solution {
    
    private static int[][] DIRECTIONS = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    
    public int getFood(char[][] grid) {
        /*
        TC: O(Rows*Cols)
        SC: O(1)
        */
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        // find start node
        int[] startPoint = new int[2];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] =='*') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    break;
                }
            }
        }
        
        q.add(startPoint);
        int steps = 0;
        boolean foodFound = false;
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int[] curr = q.poll();
                for(int[] direction : DIRECTIONS) {
                    int nextR = curr[0] + direction[0];
                    int nextC = curr[1] + direction[1];
                    if(nextR >= 0 && nextR < rows
                      && nextC >= 0 && nextC < cols
                      && (grid[nextR][nextC] == 'O' || grid[nextR][nextC] =='#')){
                        if(grid[nextR][nextC] == '#') {
                            foodFound = true;
                            break;
                        }
                        else {
                            grid[nextR][nextC] = 'X';
                            q.add(new int[]{nextR, nextC});
                        }
                    }
                }
                if(foodFound) break;
            }
            steps++;
            if(foodFound) break;
        }
        
        return foodFound ? steps : -1;
    }
}