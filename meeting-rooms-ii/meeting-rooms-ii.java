class Solution {
    public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 1) return 1;
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t1, int[] t2) {
        return t1[0] - t2[0];
      }
    });
    int ans = Integer.MIN_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(intervals[0][1]);

    for(int i = 1; i < intervals.length; i++) {
      int minEndTime = pq.peek().intValue();
      if(intervals[i][0] < minEndTime) pq.add(intervals[i][1]);
      else {
        pq.remove();
        pq.add(intervals[i][1]);
      }
    }
    return pq.size();
    }
}