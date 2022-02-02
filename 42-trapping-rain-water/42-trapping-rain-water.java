class Solution {
  public int trap(int[] height) {
    Stack<Integer> s = new Stack<>();
    int area = 0;
    int current = 0;
    while(current < height.length) {
      while(!s.isEmpty() && height[current] > height[s.peek()]) {
        int previousIdx = s.peek();
        s.pop();
        if(s.isEmpty()) break;
        int w = current - s.peek() -1;
        int h = Math.min(height[current], height[s.peek()]) - height[previousIdx];
        area += w*h;
      }
      s.add(current);
      current++;
    }
    return area;
  }
}