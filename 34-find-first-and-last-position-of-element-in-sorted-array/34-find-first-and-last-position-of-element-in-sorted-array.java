class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        
        int leftIdx = getFirstIdxOf(nums, target);
        int rightIdx = getFirstIdxOf(nums, target+1);

        if(leftIdx == nums.length || nums[leftIdx] != target) return new int[]{-1,-1};
        return new int[]{leftIdx, rightIdx-1};
    }
    
    
    private int getFirstIdxOf(int[] nums, int numberToFind) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(nums[mid] < numberToFind) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}