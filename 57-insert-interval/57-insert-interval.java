class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> insertedIntervals = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        
        //leftMost
        
        int idx = 0;
        int len = intervals.length;
        
        while(idx < len && intervals[idx][1] < newStart) {
            insertedIntervals.add(new int[]{intervals[idx][0], intervals[idx][1]});
            idx++;
        }
        
        //merge
        while(idx < len && intervals[idx][0] <= newEnd) {
            newStart = Math.min(intervals[idx][0], newStart);
            newEnd = Math.max(intervals[idx][1], newEnd);
            idx++;
        }
        insertedIntervals.add(new int[]{newStart, newEnd});
        
        //rightmost
        while(idx < len) {
            insertedIntervals.add(new int[]{intervals[idx][0], intervals[idx][1]});
            idx++;
        }
        
        return insertedIntervals.toArray(new int[0][0]);
    }
}