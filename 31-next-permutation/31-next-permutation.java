class Solution {
    public void nextPermutation(int[] nums) {
        //
        
        // nums = [1,2,3], [1,3,2]
        
        // permutation (순열)
        
        // abcde
        
        // abcde, badce, bacde, ......,........ 서로 다른 원소들을 순서를 생각해서 줄세우는 경우의 수 
        
        // (a,b,c,d,e) * 4 * 3 * 2 * 1 =  5 * 4*3*2*1. -> 5! O(N!)   
        
        // 1,2,3 -> 123 -> 132 -> 213 -> 231 -> 312 -> 321 -> 123 
        // abc, -> acb -> bac -> bca -> cab -> cba
        
        int r = nums.length - 2;
        while( r >= 0 && nums[r] >= nums[r+1]) r--;
        //[2,1]
        
        
        if(r >= 0) {
            int j = nums.length - 1;
            
            while(nums[j] <= nums[r]) j--;
            
            int temp = nums[j];
            nums[j] = nums[r];
            nums[r] = temp;
        }
        
        reverse(nums, r+1);
        
    }
    
    private void reverse (int[] nums, int startIdx) {
        int endIdx = nums.length - 1;
        
        while(startIdx <= endIdx) {
            int temp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }
}