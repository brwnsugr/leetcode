class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //[1^,1,1,1] , target = 3
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = nums[i];
            
            int semiTarget = start * (-1);
            
            int l = i + 1;
            
            int r = nums.length - 1;
            
            while(l < r) {
                int remainSum = nums[l] + nums[r];
                if(remainSum == semiTarget) {
                    res.add(Arrays.asList(start, nums[l], nums[r]));
                    l++;
                }
                else if(remainSum < semiTarget) {
                    l++;
                }
                else {
                    r--;
                }
                
                while(l > i + 1 && l < r && nums[l] == nums[l-1]) {
                    l++;
                }
            }
        }
        
        return res;
    }
}