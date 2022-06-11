class Solution {
    public boolean find132pattern(int[] nums) {
        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            minArr[i] = Math.min(minArr[i-1], nums[i-1]);
        }
        
        Stack<Integer> st = new Stack<>();
        for(int j = nums.length - 1; j >= 0; j--) {
            if(nums[j] > minArr[j]) {
                while(!st.isEmpty() && st.peek() <= minArr[j]) {
                    st.pop();
                }
                
                if(!st.isEmpty() && nums[j] > st.peek()) {
                    return true;
                }
                st.push(nums[j]);
            }
        }
        return false;
    }
}