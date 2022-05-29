class Solution {
    public int getMaxLen(int[] nums) {
        int firstNegIdx = -1;
        int startIdx = -1;
        int negCount = 0;
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                negCount++;
                if(firstNegIdx == -1) firstNegIdx = i;
            }
            else if(nums[i] == 0) {
                negCount = 0;
                firstNegIdx = -1;
                startIdx = i;
            }
            int tempLength = negCount % 2 == 0 ? i - startIdx : i - firstNegIdx;
            answer = Math.max(tempLength, answer);
        }
        return answer;
    }
}