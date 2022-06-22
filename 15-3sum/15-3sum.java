class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        // n_C_3 = n n-1 n-2 -> O(N^3)
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int complement = -first;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            checkRestSum(i+1, nums, complement);
        }
        
        return res;
    }
    
    private void checkRestSum(int start, int[] nums, int target) {
        int lo = start;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            int sum = nums[start-1] + nums[lo] + nums[hi];
            if(sum < 0) lo++;
            else if(sum > 0) hi--;
            else {
                res.add(Arrays.asList(nums[start-1], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo-1]) lo++;
            }
        }
    }
}