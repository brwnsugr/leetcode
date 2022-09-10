class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
        int currentSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSum = Math.max(currentSum + num, num);
            answer = Math.max(currentSum, answer);
        }
        return answer;
    }
}