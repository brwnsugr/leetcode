class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    Queue<Integer> nums1Q = new LinkedList<>();
    Queue<Integer> nums2Q = new LinkedList<>();
    for(int i = 0; i < m; i++) nums1Q.add(nums1[i]);
    for(int j = 0; j < n; j++) nums2Q.add(nums2[j]);
    dfs(nums1Q, nums2Q, nums1, 0);
  }

  private void dfs(Queue<Integer> nums1Q, Queue<Integer> nums2Q, int[] nums1, int currIdx) {
    if(nums1Q.isEmpty() && nums2Q.isEmpty()) return;
    else {
      int num1 = nums1Q.peek() == null ? Integer.MAX_VALUE : nums1Q.peek();
      int num2 = nums2Q.peek() == null ? Integer.MAX_VALUE : nums2Q.peek();
      int numberToPut = Math.min(num1, num2);
      int d = numberToPut == num1 ? nums1Q.poll() : nums2Q.poll();
      nums1[currIdx] = numberToPut;
      dfs(nums1Q, nums2Q, nums1, currIdx+1);
      return;
    }
  }
}