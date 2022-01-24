class Solution {
  public int maxSubArray(int[] nums) {
    int ans = Integer.MIN_VALUE;
    int subSum = 0;
    for(int i = 0; i < nums.length; i++) {
      subSum += nums[i];
      ans = Math.max(ans, subSum);
      if(subSum < 0) subSum = 0;
    }
    return ans;
  }
}