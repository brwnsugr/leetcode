class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length ==1)
            return nums[0] < k ? 1 : 0;
        int prod = 1;
        
        int l = 0;
        int r = 0;
        int answerCount = 0;
        for(r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while(prod >= k && l <= r) {
                prod /= nums[l++];
            }
            answerCount += r - l + 1;
        }
        
        return answerCount;
    }
}