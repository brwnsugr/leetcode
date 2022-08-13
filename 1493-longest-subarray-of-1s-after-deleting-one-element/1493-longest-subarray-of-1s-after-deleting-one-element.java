class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int zeros = 0;
        int answer = 0;
        
        while(r < nums.length) {
            
            if(nums[r] == 0) zeros++;
            while(zeros > 1) {
                if(nums[l] == 0) zeros--;
                l++;
            }
            answer = Math.max(answer, r - l);
            r++;
        }
        
        return answer;
    }
}