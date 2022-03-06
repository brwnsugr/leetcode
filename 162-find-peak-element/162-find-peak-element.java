class Solution {
    public int findPeakElement(int[] nums) {
        
        return getPeakIdx(nums, 0, nums.length - 1);
        
    }
    
    
    private int getPeakIdx(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        
        if(mid - 1 >= 0 && nums[mid] < nums[mid-1]) {
            //look left
            return getPeakIdx(nums, start, mid);
        }
        
        else if(mid + 1 < nums.length && nums[mid] < nums[mid+1]) {
            //look right
            return getPeakIdx(nums, mid + 1, end);
        }
        
        else {
            return mid;
        }
    }
}