class Solution {
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] > 0) break;
      if(i == 0 || nums[i-1] != nums[i]) {
        addPossibleSum(nums, i);
      }
    }
    return res;
  }

  private void addPossibleSum(int[] nums, int i) {
    Set<Integer> s = new HashSet<>();
    for(int j = i+1; j < nums.length; j++) {
      int complement = -nums[j] - nums[i];
      if(s.contains(complement)) {
        res.add(Arrays.asList(nums[i], complement, nums[j]));
        while(j + 1 < nums.length && nums[j] == nums[j+1]) j++;
      }
      s.add(nums[j]);
    }
  }
}