class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int rooms = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int i = 0; i < intervals.length; i++) {
            while(!pq.isEmpty() && intervals[i][0] >= pq.peek()[1]) {
                pq.remove();
            }
            
            pq.add(intervals[i]);
            rooms = Math.max(rooms, pq.size());
        }
        
        return rooms;
    }
}