class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;

        int max = nums.length;
        
        return (1 + max) * max / 2 - sum;        
    }
}