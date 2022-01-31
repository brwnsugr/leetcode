class Solution {
  public int[] countBits(int n) {
    int[] ans = new int[n+1];
    for(int i = 0; i <= n; i++) {
      ans[i] = getCount(i);
    }
    
    return ans;
  }

  private int getCount(int input) {
    int count = 0;
    while(input != 0) {
      input = input & (input -1);
      count++;
    }
    return count;
  }
}