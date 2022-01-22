class Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int[] hidden = new int[differences.length+1];
    hidden[0] = 0;
    long hiddenMin = 0;
    long hiddenMax = 0;
    for(int i = 0; i < differences.length; i++) {
      hidden[i+1] = differences[i] + hidden[i];
      hiddenMin = Math.min(hiddenMin, hidden[i+1]);
      hiddenMax = Math.max(hiddenMax, hidden[i+1]);
    }

    long maxDiff = hiddenMax - hiddenMin;
    long ret = upper - lower - maxDiff + 1;
    return ret > 0 ? (int) ret : 0;
  }
}