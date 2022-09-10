class Solution {
    public int maxSubArray(int[] nums) {
        int tempSum = 0;
        int answer = Integer.MIN_VALUE;
        for(int num : nums) {
            tempSum += num;
            answer = Math.max(answer, tempSum);
            if(tempSum < 0) tempSum = 0;
        }
        
        return answer;
    }
}