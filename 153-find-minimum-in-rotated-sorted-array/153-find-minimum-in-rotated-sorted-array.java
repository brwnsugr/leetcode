class Solution {
    public int findMin(int[] nums) {
        
        // find the bottom edge point 
        // [1l,2,0lr], mid = 1
        int l = 0;
        int r = nums.length - 1;
        int answer = nums[0];
        
        int mid = 0;
        while(l < r) {
            mid = l + (r-l)/2;
            
            if(nums[mid] > nums[r]) {
                l = mid+1;
                answer = nums[l];
            }
            else {
                r = mid;
                answer = nums[r];
            }
        }
        
        return answer;
    
    }
}