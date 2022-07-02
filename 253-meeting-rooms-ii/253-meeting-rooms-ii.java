class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < intervals.length; i++) {
            pq.add(intervals[i][1]);
            int minEndTime = pq.peek().intValue();
            if(intervals[i][0] >= minEndTime) pq.remove();
        }
        return pq.size();
    }
}