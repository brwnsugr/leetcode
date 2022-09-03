class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval == null || interval[1] < newInterval[0]) {
                newIntervals.add(interval);
            }
            else if(newInterval[1] < interval[0]) {
                newIntervals.add(newInterval);
                newIntervals.add(interval);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        if(newInterval != null) newIntervals.add(newInterval); 
        //
        return newIntervals.toArray(new int[newIntervals.size()][]);
        //
        
    }
}