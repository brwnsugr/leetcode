class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.add(i);
        }
        // [1,2,3] ->, ans = [0,0,0] 
        return answer;
    }
}