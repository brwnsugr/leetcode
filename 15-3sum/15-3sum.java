class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> resSet = new HashSet<>();
    Set<Integer> firstDups = new HashSet<>();
    Map<Integer, Integer> seen = new HashMap<>();
    
    for(int i = 0; i < nums.length - 2; i++) {
      if(firstDups.add(nums[i])) {
        for(int j = i+1; j < nums.length; j++) {
          int complement = -nums[i] -nums[j];
          if(seen.containsKey(complement) && seen.get(complement) == i) {
            List<Integer> res = Arrays.asList(complement, nums[i], nums[j]);
            Collections.sort(res);
            resSet.add(res);
          }
          seen.put(nums[j], i);
        }
      }
    }
    return new ArrayList<>(resSet);
  }
}