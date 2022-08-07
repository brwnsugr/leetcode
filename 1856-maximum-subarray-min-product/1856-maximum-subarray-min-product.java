class Solution {
    public int maxSumMinProduct(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];
        
        for(int i = 1; i <= nums.length; i++) {
            prefixSum[i] = nums[i-1] + prefixSum[i-1];
        }
        
        Stack<Integer> st = new Stack<>();
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                left[i] = -1;
            }
            else {
                left[i] = st.peek();
            }
            
            st.add(i);
        }
        
        st.clear();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) right[i] = nums.length;
            else right[i] = st.peek();
            st.add(i);
        }
        
        long answer = 0;
        for(int i = 0; i < nums.length; i++) {
            int l = left[i];
            
            int r = right[i];
            
            long sum = prefixSum[r] - prefixSum[l + 1];
            long prod = sum * nums[i];
            answer = Math.max(prod , answer);
        }
        return (int) (answer % 1_000_000_007);
    }
}