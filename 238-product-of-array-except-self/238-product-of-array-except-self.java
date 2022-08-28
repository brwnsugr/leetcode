class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProducts = new int[len];
        int[] rightProducts = new int[len];
        int leftProduct = 1;
        int rightProduct = 1;
        for(int i = 0; i < len; i++) {
            leftProduct = leftProduct * nums[i];
            leftProducts[i] = leftProduct;
            rightProduct = rightProduct * nums[len - i - 1];
            rightProducts[len - i - 1] = rightProduct;
        }
        
        int[] ans = new int[len];
        
        for(int i = 0; i < len; i++) {
            if(i == 0) ans[i] = rightProducts[1];
            else if(i == len -1) ans[i] = leftProducts[len - 2];
            else {
                ans[i] = leftProducts[i - 1] * rightProducts[i + 1];
            }
        }
        
        return ans;
    }
}