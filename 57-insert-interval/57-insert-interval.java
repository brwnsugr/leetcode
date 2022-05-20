class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        int len = intervals.length;
        List<int[]> newIntervals = new ArrayList<>();
        
        while(idx < len && intervals[idx][1] < newInterval[0]) {
            newIntervals.add(new int[]{intervals[idx][0], intervals[idx][1]});
            idx++;
        }
        int mergedLeft = newInterval[0];
        int mergedRight = newInterval[1];
        boolean merged = false;
        while(idx < len && mergedRight >= intervals[idx][0]) {
            mergedRight = Math.max(mergedRight, intervals[idx][1]);
            mergedLeft = Math.min(mergedLeft, intervals[idx][0]);
            idx++;
        }
        newIntervals.add(new int[]{mergedLeft, mergedRight});
        
        while(idx < len) {
            newIntervals.add(intervals[idx]);
            idx++;
        }
        
        
        int[][] res = new int[newIntervals.size()][2];
        
        int i = 0;
        for(int[] interval : newIntervals) {
            res[i][0] = interval[0];
            res[i][1] = interval[1];
            i++;
        }
        return res;
    }
}