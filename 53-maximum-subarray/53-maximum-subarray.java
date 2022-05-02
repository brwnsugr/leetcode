class Solution {
    public int maxSubArray(int[] nums) {
        //O(N^2)

        return getMaxConsecutiveSum(0, nums.length-1, nums);
    }
    
    
    private int getMaxConsecutiveSum(int left, int right, int[] nums) {
        
        if(left > right) return Integer.MIN_VALUE;
        
        int mid = (left + right) / 2;
        
        // left Biggest Sum 
        int leftBiggestSum = 0;
        int leftTemp = 0;
        for(int i = mid - 1; i >= left; i--) {
            leftTemp += nums[i];
            leftBiggestSum = Math.max(leftBiggestSum, leftTemp);
        }
        
        int rightBiggestSum = 0;
        int rightTemp = 0;
        for(int j = mid + 1; j <= right; j++) {
            rightTemp += nums[j];
            rightBiggestSum = Math.max(rightBiggestSum, rightTemp);
        }
        
        int bestSum = nums[mid] + leftBiggestSum + rightBiggestSum;
        
        int leftHalf = getMaxConsecutiveSum(left, mid -1, nums);
        int rightHalf = getMaxConsecutiveSum(mid+1, right, nums);
        
        return Math.max(leftHalf, Math.max(rightHalf, bestSum));
        
        // right Biggest Sum
        
    }
}