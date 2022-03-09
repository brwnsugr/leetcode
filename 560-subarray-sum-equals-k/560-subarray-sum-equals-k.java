class Solution {
    public int subarraySum(int[] nums, int k) {
    
        
        //set the starting point at the array 
        // from the starting point, we cumulatively sum it and check if its summations equals k 
        // then added answer by 1 
    //       ^ ^ 
        //[1,1,2,3]
        // k= 3
        
        
        int answer = 0;
        for(int start = 0; start < nums.length; start++) {
            int partialSum = 0;
            for(int end = start; end < nums.length; end++) {
                partialSum += nums[end];
                if(partialSum == k) answer++;
            }
        }
        return answer;
    }
}