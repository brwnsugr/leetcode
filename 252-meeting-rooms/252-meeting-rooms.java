class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length < 2) return true;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] prevInterval = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if(isOverlapping(prevInterval, intervals[i]))
               return false;
            prevInterval = intervals[i];   
        }
        
        return true;
    }
    
    private boolean isOverlapping(int[] a, int[] b) {
        return a[0] < b[1] && a[1] > b[0];
    }
}