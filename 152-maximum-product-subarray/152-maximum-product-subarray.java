class Solution {
    public int maxProduct(int[] nums) {
        //[1,0,(1,2)],
        //[]
        //
        int answer = Integer.MIN_VALUE;
        int tempProduct = 1;
        for(int i = nums.length -1 ; i>= 0; i--) {
            if(nums[i] == 0) {
                tempProduct = 1;
                answer = Math.max(answer, 0);
            }
            else {
                tempProduct *= nums[i];
                answer = Math.max(answer, tempProduct);
            }
        }
        
        tempProduct = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                tempProduct = 1;
                answer = Math.max(answer, 0);
            }
            else {
                tempProduct *= nums[i];
                answer = Math.max(answer, tempProduct);
            }
        }
        return answer;
    }
}