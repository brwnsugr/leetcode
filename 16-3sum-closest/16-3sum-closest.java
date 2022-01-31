class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int minDiff = Integer.MAX_VALUE;
    int ans = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length -2; i++) {
      int firstOne = nums[i];
      int semiTarget = target - firstOne;

      int left = i+1;
      int right = nums.length - 1;
      while(left < right) {
        int diff = Math.abs(semiTarget - (nums[left] + nums[right]));
        if(diff < minDiff) {
          minDiff = diff;
          ans = firstOne + nums[left] + nums[right];
        }
        if(semiTarget > nums[left] + nums[right]) {
          left++;
        }
        else {
          right--;
        }
      }
    }
    return ans;
  }
}