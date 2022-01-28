class Solution {
  public int[] prisonAfterNDays(int[] cells, int n) {
    Map<Integer, Integer> s = new HashMap<>();
    boolean fastForward = false;
    while(n > 0) {
      if(!fastForward) {
        if(s.containsKey(convertToBitMap(cells))) {
          n = n % (s.get(convertToBitMap((cells))) - n);
          fastForward = true;
        }
        else {
          s.put(convertToBitMap(cells), n);
        }
      }
      if(n > 0) {
        n--;
        cells = call(cells);
      }
    }
    return cells;
  }

  private int[] call(int[] cells) {
    int[] newCells = new int[cells.length];
    newCells[0] = 0;
    newCells[cells.length-1] = 0;
    for(int i = 1; i < cells.length -1; i++) {
      newCells[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
    }
    return newCells;
  }

  private int convertToBitMap(int[] cells) {
    int stateBitMap = 0;
    for (int cell : cells) {
      stateBitMap <<= 1;
      stateBitMap = (stateBitMap | cell);
    }
    return stateBitMap;
  }
}