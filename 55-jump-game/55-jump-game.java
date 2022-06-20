class Solution {
    public boolean canJump(int[] nums) {
        int leftMostPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            
            if(i + nums[i] >= leftMostPos) {
                leftMostPos = i;
            }
        }
        
        
        return leftMostPos == 0;
    }
}