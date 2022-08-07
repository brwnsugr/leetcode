class Solution {
    
    private int answer = -1;
    
    public int triangularSum(int[] nums) {
        recursion(nums);
        
        return answer;
    }
    
    private void recursion(int[] nums) {
        if(nums.length == 1) {
            answer = nums[0];
            return;
        }
        else {
            int[] newNums = new int[nums.length - 1];
            for(int i = 0; i < nums.length - 1; i++) {
                newNums[i] = (nums[i] + nums[i+1]) % 10;
            }
            recursion(newNums);
        }
    }
    
    
}