class Solution {
    public int trap(int[] height) {
        
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int r = 0; r < height.length; r++) {
            int currHeight = height[r];
            
            
            while(!st.isEmpty() && currHeight > height[st.peek()]) {
                int bottom = height[st.peek()];
                st.pop();
                if(st.isEmpty()) break;
                int tempWidth = r - st.peek() - 1;
                int tempHeight = Math.min(height[st.peek()], currHeight) - bottom;
                answer += tempWidth * tempHeight;
            }
            st.add(r);
        }
        
        return answer;
    }
}