class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        st.add(-1);
        // st.add(0);
        int maxArea = 0;
        
        for(int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            while(st.size() > 1 && currHeight <= heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                
                maxArea = Math.max(maxArea, width * height);
                // st.pop();
            }
            
            st.add(i);
        }
        int length = heights.length;
        while(st.peek() != -1) {
            int height = heights[st.pop()];
            int width = length - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
            // st.pop();
        }
        return maxArea;
    }
}