class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            minArr[i] = Math.min(nums[i-1], minArr[i-1]);
        }
        Stack<Integer> st = new Stack<>();
        for(int j = nums.length-1; j >= 0; j--) {
            if(nums[j] > minArr[j]) {
                while(!st.isEmpty() && st.peek() <= minArr[j]) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() < nums[j]){
                    return true;
                }
                st.add(nums[j]);
            }
        }
        
        return false;
    }
}