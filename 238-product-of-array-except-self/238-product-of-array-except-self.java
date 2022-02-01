class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] lefts = new int[n];
    int[] rights = new int[n];

    int l = 0;
    int r = n-1;

    while(l < n && r > 0) {
      if(l == 0 && r == n -1) {
        lefts[l] = nums[l];
        rights[r] = nums[r];
      }
      else {
        lefts[l] = nums[l] * lefts[l-1];
        rights[r] = nums[r] * rights[r+1];
      }
      l++; r--;
    }

    int[] ans = new int[n];

    for(int i = 0; i < ans.length; i++) {
      if(i==0) ans[i] = rights[i+1];
      else if(i == ans.length -1) ans[i] = lefts[i-1];
      else{
        ans[i] = lefts[i-1] * rights[i+1];
      }
    }
    return ans;
  }
}