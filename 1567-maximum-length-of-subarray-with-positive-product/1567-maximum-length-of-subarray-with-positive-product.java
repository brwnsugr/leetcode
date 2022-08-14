class Solution {
    public int getMaxLen(int[] nums) {
        int lastNegIdx = -1;
        int nonZeroStartIdx = -1;
        int firstNegIdx = -1;
        int negCount = 0;
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr == 0) {
                nonZeroStartIdx = i;
                negCount = 0;
                firstNegIdx = -1;
            }
            else {
                if(curr < 0) {
                    negCount++;
                    lastNegIdx = i;
                    if(firstNegIdx == -1) firstNegIdx = i;
                }

                int tempLen = negCount % 2 == 0 ? i - nonZeroStartIdx : i - firstNegIdx;
                answer = Math.max(tempLen, answer);
            }
        }
        
        return answer;
    }
}