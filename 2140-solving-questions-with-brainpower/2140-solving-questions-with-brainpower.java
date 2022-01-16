class Solution {
  long[] cache;
  public long mostPoints(int[][] questions) {
    cache = new long[questions.length];
    return dfs(questions, 0);
  }

  private long dfs(int[][] questions, int currIdx) {
    int qLen = questions.length;
    if(currIdx >= qLen) {
      return 0;
    }
    else if(cache[currIdx] > 0) {
      return cache[currIdx];
    }
    else {
      int points = questions[currIdx][0];
      int steps = questions[currIdx][1];
      cache[currIdx] = Math.max(dfs(questions, currIdx+1), points + dfs(questions, currIdx + 1 + steps));
      return cache[currIdx];
    }
  }
}