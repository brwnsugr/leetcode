class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while(!st.isEmpty() && temperatures[st.peek()] < currTemp) {
                int prev = st.pop();
                ans[prev] = currDay - prev;
            }
            st.add(currDay);
        }
        
        return ans;
    }
}