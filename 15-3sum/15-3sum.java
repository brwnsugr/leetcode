class Solution {
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    int target = 0;
    Arrays.sort(nums);
    for(int i = 0; i< nums.length-2; i++) {
      int semiTarget = target - nums[i];
      /**
       * we get Two Sum from the two indices which are bigger than ith idx
       */
      if(i == 0 || nums[i-1] != nums[i]) {
        getTwoSum(nums, i+1, nums.length, semiTarget);
      }
    }
    return res;
  }

  private void getTwoSum(int[] nums, int start, int end, int target) {
    Set<Integer> s = new HashSet<>();
    for(int i = start; i < end; i++) {
      int complement = target - nums[i];
      if(s.contains(complement)) {
        res.add( Arrays.asList(-target, complement, nums[i]));
        while(i + 1 < end && nums[i] == nums[i+1]) {
          i++;
        }
      }
      s.add(nums[i]);
    }
  }
}