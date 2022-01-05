class Solution {
  public static List<int[]> DIRECTIONS = Arrays.asList(
      new int[]{1, 0},
      new int[]{0,1},
      new int[]{-1,0},
      new int[]{0,-1}
  );

  public int numIslands(char[][] grid) {
    int islandsCount = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == '1') {
          islandsCount++;
          dfs(new int[]{i,j}, grid);
        }
      }
    }
    return islandsCount;
  }

  private void dfs(int[] currPoint, char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    grid[currPoint[0]][currPoint[1]] = '0';
    for(int[] direction : DIRECTIONS) {
      int nextY = currPoint[0] + direction[0];
      int nextX = currPoint[1] + direction[1];
      if(nextY >= 0 && nextY < m
        && nextX >= 0 && nextX < n
        && grid[nextY][nextX] == '1') {
        dfs(new int[]{nextY, nextX}, grid);
      }
    }
    return;
  }
}