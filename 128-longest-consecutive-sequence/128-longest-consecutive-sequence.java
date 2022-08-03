class Solution {
    public int longestConsecutive(int[] nums) {
        // 1,2,3,4,6,7  ---  100,200     -> 
        if(nums.length == 0) return 0;
        int answer = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int tempLength = 1;
            while(i+1 < nums.length && (curr + 1 == nums[i+1] || curr == nums[i+1])) {
                if(curr+1 == nums[i+1]) tempLength++;
                curr = nums[i+1];
                i++;
            }
            answer = Math.max(answer, tempLength);
        }
        
        return answer;
    }
}