class Solution {
    
    private static int[][] DIRECTIONS = new int[][]{
        {1,2},
        {2,1},
        {-1,2},
        {-2,1},
        {-2,-1},
        {-1,-2},
        {2,-1},
        {1,-2}
    };
    
    public int minKnightMoves(int x, int y) {
        int[] startPoint = new int[]{0,0};
        boolean[][] visited = new boolean[601][601];
        int steps = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int[] currPoint = q.poll();
                int currX = currPoint[0];
                int currY = currPoint[1];
                // visited[currX+300][currY+300] = true;
                if(currX == x && currY == y) return steps;

                for(int[] direction : DIRECTIONS) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];
                    if(nextX >= -300 && nextX <= 300
                      && nextY >= -300 && nextY <= 300
                      && !visited[nextX+300][nextY+300]) {
                        visited[nextX+300][nextY+300] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
            steps++;
        }
        
        
        return steps;
    }
}