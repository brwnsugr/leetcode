class Solution {
    
    private List<List<Integer>> answers = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        //try all the comb of nums and check if it equqls target
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int semiTarget = -nums[i];
            appendTriplets(semiTarget, i + 1, nums);
        }
        
        return answers;
    }
    
    private void appendTriplets(int semiTarget, int start, int[] nums) {
        int end = nums.length - 1;
        
        
        while(start < end) {
            int startVal = nums[start];
            int endVal = nums[end];
            
            if(startVal + endVal < semiTarget) {
                start++;
            }
            
            else if(startVal + endVal > semiTarget) {
                end--;
            }
            
            else {
                answers.add(Arrays.asList(-semiTarget, nums[start++], nums[end--]));
                while(start < end && nums[start] == nums[start-1]) start++;
            }
            
        }        
        
        return;
    }
    
    
    
}