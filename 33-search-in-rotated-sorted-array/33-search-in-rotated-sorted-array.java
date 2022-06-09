class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l <= r) {
            int mid = l + (r-l)/2; // l, (r-l)/2
            if(nums[mid] == target) return mid;
            if(nums[r] == target) return r;
            if(nums[l] == target) return l;
            if(nums[mid] > nums[r]) {
                if(target < nums[r] || target > nums[mid]) {
                    // find right
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            else {
                if(target < nums[mid] || target > nums[r]) {
                    r = mid - 1; // left 
                }
                else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}