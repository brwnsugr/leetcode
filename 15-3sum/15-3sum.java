class Solution {
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i < nums.length -2; i++) {
      if(nums[i] > 0) break;
      if(i == 0 || nums[i-1] != nums[i]) addThreeSum(nums, i);
    }
    return res;
  }

  private void addThreeSum(int[] nums, int i) {
    int lo = i + 1;
    int hi = nums.length-1;
    while(lo < hi) {
      int sum = nums[lo] + nums[hi] + nums[i];
      if(sum < 0) {
        lo++;
      }
      else if(sum > 0) {
        hi--;
      }
      else {
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        lo++; hi--;
        while(lo < hi && nums[lo] == nums[lo-1]) lo++;
      }
    }
  }
}