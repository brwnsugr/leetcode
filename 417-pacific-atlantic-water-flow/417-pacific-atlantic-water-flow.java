class Solution {
  private final List<int[]> DIRECTIONS = Arrays.asList(
      new int[]{0,1},
      new int[]{1,0},
      new int[]{-1,0},
      new int[]{0,-1}
  );

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    /**
     * We separate Two Starting border parts, by both Oceans.
     * first part is left and top side border, and Second part is right and bottom side border
     *
     * from that borders, we traverse from each points of border and check any point is reacheable to ocean or not
     * so, any points which are reacheable to both ocean would be one of the answer list.
     */
    List<List<Integer>> res = new ArrayList<>();

    int rows = heights.length;
    int cols = heights[0].length;
    
    Queue<int[]> pacificQueue = new LinkedList<>();
    Queue<int[]> atlanticQueue = new LinkedList<>();
    for(int i = 0; i < rows; i++) {
      pacificQueue.add(new int[]{i, 0});
      atlanticQueue.add(new int[]{i, cols-1});
    }

    for(int i = 0; i < cols; i++) {
      pacificQueue.add(new int[]{0,i});
      atlanticQueue.add(new int[]{rows-1, i});
    }

    boolean[][] pacificFlow = bfs(heights, pacificQueue, rows, cols);
    boolean[][] atlanticFlow = bfs(heights, atlanticQueue, rows, cols);

    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        if(pacificFlow[i][j] && atlanticFlow[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }
    return res;
  }

  private boolean[][] bfs(int[][] heights, Queue<int[]> q, int rows, int cols) {
    boolean[][] reacheable = new boolean[rows][cols];
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      reacheable[curr[0]][curr[1]] = true;
      for(int[] direction : DIRECTIONS) {
        int nextR = curr[0] + direction[0];
        int nextC = curr[1] + direction[1];
        if(nextR >= 0 && nextR < rows
            && nextC >= 0 && nextC < cols
            && !reacheable[nextR][nextC]
            && heights[nextR][nextC] >= heights[curr[0]][curr[1]]) {
          q.add(new int[]{nextR, nextC});
        }
      }
    }
    return reacheable;
  }
}