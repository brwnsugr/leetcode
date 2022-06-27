class Solution {
    
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int pairTarget = -nums[i];
            if(i != 0 && nums[i] == nums[i-1]) continue;
            buildPairTarget(pairTarget, i + 1, nums);
        }
        return res;
    }
    
    private void buildPairTarget(int target, int start, int[] nums) {
        int l = start;
        int r = nums.length - 1;
        
        
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum > target) {
                r--;
            }
            else if(sum < target) {
                l++;
            }
            else {
                res.add(Arrays.asList(-target, nums[l++], nums[r--]));
                while(l < r && nums[l] == nums[l-1]) l++;
            }
        }
        
    }
}