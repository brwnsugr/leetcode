class Solution {
    public int splitArray(int[] nums, int m) {
        int right = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            right += nums[i];
            left = Math.max(nums[i], left);
        }
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(feasible(nums, mid, m)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    
    private boolean feasible(int[] nums, int sum, int threshold) {
        
        int totalSum = 0;
        int count = 1;
        
        for(int num : nums) {
            totalSum += num;
            if(totalSum > sum) {
                totalSum = num;
                count++;
                if(count > threshold) return false;
            }
        }
        return true;
    }
}