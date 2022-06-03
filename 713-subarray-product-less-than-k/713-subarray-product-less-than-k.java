class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int tempProduct = 1;
            for(int j = i; j < nums.length; j++) {
                if(i==j) {
                    tempProduct = nums[i];
                }
                else {
                    tempProduct *= nums[j];
                }
                
                
                if ( tempProduct < k) count++;
                if (tempProduct >= k) break;
            }
        }
        
        return count;
    }
}