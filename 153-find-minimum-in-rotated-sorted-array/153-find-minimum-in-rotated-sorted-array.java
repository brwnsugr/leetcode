class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length-1]) return nums[0];
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int temp = (r-l) / 2;
            int mid = l + temp;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid-1] > nums[mid]) return nums[mid];
            
            
            if(nums[mid] > nums[0]) {
                l = mid + 1; 
            }
            else {
                r = mid;
            }
        }
        return -1;
    }
}