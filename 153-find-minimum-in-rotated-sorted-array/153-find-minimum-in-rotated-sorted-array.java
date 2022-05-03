class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        //[0,2,3]  , l=0,r=1, m=0
        while(l < r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]) l = mid+1;
            else r = mid;
        }
        return nums[r];
    }
}