class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] cumSum = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++) {
            cumSum[i+1] = nums[i] + cumSum[i];
        }
        
        int answer = 0;
        for(int start = 0; start < nums.length; start++) {
            for(int end = start + 1 ; end <= nums.length; end++) {
                if(cumSum[end] - cumSum[start] == k) answer++;
            }
        }
        return answer;
    }
}