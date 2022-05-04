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
        Set<Integer> visited = new HashSet<>();
        for(int i = start; i < nums.length; i++) {
            int complement = target - nums[i];
            if(visited.contains(complement)) {
                res.add(Arrays.asList(nums[start-1], complement, nums[i]));
                while(i < nums.length -1 &&nums[i] == nums[i+1]) i++;
            }
            visited.add(nums[i]);
        }
    }
}