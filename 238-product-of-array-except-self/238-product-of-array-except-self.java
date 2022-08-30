class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);
        int zeroCounts = 0;
        for(int num : nums) {
            if(num == 0) zeroCounts++;
        }
        
        if(zeroCounts == 0) {
            int products = 1;
            for(int num : nums) products *= num;
            for(int i = 0; i < nums.length; i++) 
                res[i] = products / nums[i];
        }
        else if(zeroCounts == 1) {
            int products = 1;
            int zeroIdx = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    zeroIdx = i;
                }
                else products *= nums[i];
            }
            res[zeroIdx] = products;
        }

        return res;
    }
}