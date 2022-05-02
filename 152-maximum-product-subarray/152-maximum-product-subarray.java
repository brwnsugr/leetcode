class Solution {
    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int tempAnswer = 1;
            for(int j = i; j < nums.length; j++) {
                tempAnswer *= nums[j];
                answer = Math.max(answer, tempAnswer);
            }
        }
        return answer;
    }
}