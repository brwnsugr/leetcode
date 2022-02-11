class Solution { 
  public static int[][] DIRECTIONS = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};

  public int cutOffTree(List<List<Integer>> forest) {
    int totalSteps = 0;
     int dummy = 0;
    List<int[]> sortedForest = getSortedForest(forest);
    int currY = 0;
    int currX = 0;
    while(!sortedForest.isEmpty()) {
      int[] currPoint = sortedForest.remove(0);
      int steps = getMinimumStep(currY, currX, currPoint[0], currPoint[1], forest);
      if(steps == -1) return -1;
      totalSteps += steps;
      forest.get(currY).set(currX, 1);
      currY = currPoint[0];
      currX = currPoint[1];
    }
    return totalSteps;
  }

  private int getMinimumStep(int startY, int startX, int aimY, int aimX, List<List<Integer>> forest) {
    int minSteps = 0;
    int cols = forest.size();
    int rows = forest.get(0).size();
    boolean[][] visited = new boolean[cols][rows];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startY, startX});
    visited[startY][startX] = true;

    while(!q.isEmpty()) {
      int qSize = q.size();
      for(int i = 0; i < qSize; i++) {
        int[] currPoint = q.poll();
        int currY = currPoint[0];
        int currX = currPoint[1];
        if(currY == aimY && currX == aimX) {
          return minSteps;
        }
        for(int[] direction : DIRECTIONS) {
          int nextY = currY + direction[0];
          int nextX = currX + direction[1];
          if(nextY >= 0 && nextY < cols
            && nextX >= 0 && nextX < rows
            && !visited[nextY][nextX]
            && forest.get(nextY).get(nextX) != 0) {
            q.add(new int[]{nextY, nextX});
            visited[nextY][nextX] = true;
          }
        }
      }
      minSteps++;
    }
    return -1;
  }

  private List<int[]> getSortedForest(List<List<Integer>> forest){
    List<int[]> res = new ArrayList<>();
    int m = forest.size();
    int n = forest.get(0).size();
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(forest.get(i).get(j) > 1) {
          res.add(new int[]{i, j, forest.get(i).get(j)});
        }
      }
    }
    Collections.sort(res, new Comparator<int[]>() {
      @Override
      public int compare(int[] t1, int[] t2) {
        return t1[2] - t2[2];
      }
    });
    return res;
  }
}