class Solution {
    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int tempAnswer = 1;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0) {
                    answer = Math.max(answer, 0);
                    tempAnswer = 1;
                    continue;
                }
                tempAnswer *= nums[j];
                answer = Math.max(answer, tempAnswer);
            }
        }
        
        return answer;
    }
    
    //
}