class Solution {
  public int maxArea(int[] height) {

    /**
     * Setting the two pointer leftmost, rightMost of the height
     *
     * and narrow between the two pointers leftMost++ moving on the right,  rightMost moving on the left direction
     *
     * and height of the leftmost is bigger than the height that are at the rightmost pointer,
     * moving on the rightMost on the left.
     *
     * and in the opposite case, Moving leftMost pointer to the right;
     *
     * and each process(narrowing the pointer by one), we calculate the area covered by that two pointers,
     * and updated the answer if that area is bigger than previous answer
     *
     *
     */

    int l = 0;
    int r = height.length-1;
    int area = 0;

    while(l < r) {
      int currentArea = (r-l) * Math.min(height[r], height[l]);
      area = Math.max(currentArea, area);
      if(height[l] < height[r]) {
        l++;
      }
      else {
        r--;
      }
    }
    return area;
  }
}