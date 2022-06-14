class Solution {
    
    private int count = 0;
    private int total = 0;
    private int[][] cache;
    
    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) total += num;
        cache = new int[nums.length][total*2 + 1];
        for(int[] cacheRow : cache) {
            Arrays.fill(cacheRow, -1);
        }
        return calculate(nums, 0, 0, target);
    }
    
    private int calculate(int[] nums, int i , int sum, int S) {
        if(i == nums.length) {
            if(sum == S) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        else {
            if(cache[i][sum + total] != -1) {
                return cache[i][sum + total];
            }
            
                int add = calculate(nums, i+1, sum + nums[i], S);
                int subtract = calculate(nums, i+1, sum - nums[i], S);
                
                cache[i][sum + total] = add+subtract;
                return cache[i][sum + total];
    
        }
    }
}