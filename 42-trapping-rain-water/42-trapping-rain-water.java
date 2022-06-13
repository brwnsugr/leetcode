class Solution {
  public int trap(int[] height) {
      Stack<Integer> st = new Stack<>();
      int area = 0;
      
      for(int currPos = 0; currPos < height.length; currPos++) {
          int currHeight = height[currPos];
          while(!st.isEmpty() && height[st.peek()] < currHeight) {
              int top = st.peek();
              st.pop();
              if(st.isEmpty()) break;
              int width = currPos - st.peek() - 1;
              int tempHeight = Math.min(height[currPos], height[st.peek()]) - height[top];
              area += width * tempHeight;
          } 
          st.add(currPos);
      }
      
      return area;
  }
}