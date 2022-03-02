class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1. sort -> O(NlogN)
        
        
        // [1,2,2,3] k = 3 -> 1,2, (3)
        // [1,2,3,4,5,6]
                     // ^
        // [1,2,2,3,3,4,5,5,6] , lI: 4, k = 0
        Arrays.sort(nums);
        
        int lastIdx = nums.length - 1;
        while(k > 0) {
            lastIdx--;
            k--;
        }
        return nums[lastIdx+1];
    }
}