class TicTacToe {
  private Map<Integer, Integer> p1ColMap;
  private Map<Integer, Integer> p1RowMap;
  private Map<Integer, Integer> p1DiagonalMap;
  private Map<Integer, Integer> p2ColMap;
  private Map<Integer, Integer> p2RowMap;
  private Map<Integer, Integer> p2DiagonalMap;
  private int size;
    public TicTacToe(int n) {
        p1ColMap = new HashMap<>();
        p1RowMap = new HashMap<>();
        p1DiagonalMap = new HashMap<>();
        p2ColMap = new HashMap<>();
        p2RowMap = new HashMap<>();
        p2DiagonalMap = new HashMap<>();
        size = n;
    }
    

  public int move(int row, int col, int player) {
    if(player == 1) {
      p1ColMap.put(col, p1ColMap.getOrDefault(col, 0) + 1);
      p1RowMap.put(row, p1RowMap.getOrDefault(row, 0) + 1);
      if(row + col == size-1) p1DiagonalMap.put(-1, p1DiagonalMap.getOrDefault(-1, 0) + 1);
      if(row == col) p1DiagonalMap.put(1, p1DiagonalMap.getOrDefault(1, 0) + 1);
      if(checkWin(p1ColMap, col) || checkWin(p1RowMap, row) || checkWin(p1DiagonalMap, 1) || checkWin(p1DiagonalMap, -1)) return player;
    }
    else {
      p2ColMap.put(col, p2ColMap.getOrDefault(col, 0) + 1);
      p2RowMap.put(row, p2RowMap.getOrDefault(row, 0) + 1);
      if(row + col == size-1) p2DiagonalMap.put(-1, p2DiagonalMap.getOrDefault(-1, 0) + 1);
      if(row == col) p2DiagonalMap.put(1, p2DiagonalMap.getOrDefault(1, 0) + 1);
      if(checkWin(p2ColMap, col) || checkWin(p2RowMap, row) || checkWin(p2DiagonalMap, 1) || checkWin(p2DiagonalMap, -1)) return player;
    }
    return 0;
  }
  
  private boolean checkWin(Map<Integer, Integer> m, int key) {
    return m.containsKey(key) && m.get(key) == size;
  }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */