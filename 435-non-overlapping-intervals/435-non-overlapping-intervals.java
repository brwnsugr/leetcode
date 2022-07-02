class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] prevInterval = intervals[0];
        int eraseCount = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            if(isOverlapping(prevInterval, intervals[i])) {
                int currEnd = intervals[i][1];
                int prevEnd = prevInterval[1];
                
                if(prevEnd >= currEnd) {
                    prevInterval = intervals[i];
                }
                eraseCount++;
            }
            else {
                prevInterval = intervals[i];
            }
        }
        
        
        
        
        return eraseCount;
    }
    
    
    private boolean isOverlapping(int[] a, int[] b) {
        return a[0] < b[1] && a[1] > b[0];
    }
}