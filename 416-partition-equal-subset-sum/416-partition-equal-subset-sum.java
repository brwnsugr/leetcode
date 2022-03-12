class Solution {
    
    private int target;
    private Boolean cache[][];
    
    public boolean canPartition(int[] nums) {
        
        target = 0;
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        target = sum / 2;
        cache = new Boolean[nums.length+1][sum+1];
        
        return isValid(nums, nums.length, 0);
    }
    
    private boolean isValid(int[] nums, int remainCount, int cumSum) {
        if(cumSum == target) {
            return true;
        }
        if(remainCount == 0 || cumSum > target) {
            cache[remainCount][cumSum] = false;
            return false;
        }
        if(cache[remainCount][cumSum] != null) return cache[remainCount][cumSum]; 
        if(isValid(nums, remainCount-1, cumSum+nums[remainCount-1]) || isValid(nums, remainCount-1, cumSum)) {
            return true;
        }
        
        cache[remainCount][cumSum] = false;
        return false;
        
    }
}