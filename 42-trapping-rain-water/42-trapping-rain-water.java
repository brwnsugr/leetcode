class Solution {
  public int trap(int[] height) {
    // if we meet higher wall than previous height,
    // then we move left til we meet higher than height[current]
    //
    //
    Stack<Integer> s = new Stack<>();
    int answer = 0;
    int currIdx = 0;  // [1,0,1]
    s.add(currIdx); // s = [0, 1]
    while(!s.isEmpty() && currIdx < height.length - 1) {
      currIdx++;
      // int currHeight = height[s.top()];
      while (!s.isEmpty() && height[s.peek()] < height[currIdx]) {
        int currHeight = height[s.peek()];
        s.pop();
        if(s.isEmpty()) break;
        int width = currIdx - s.peek() - 1;
        int heightDiff = Math.min(height[currIdx], height[s.peek()]) - currHeight;
        answer += (width * heightDiff);
      }
      s.add(currIdx);
    }

    return answer;

  }
}