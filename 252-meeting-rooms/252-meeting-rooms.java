class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // ( ) 
        //    (   ) (  )
        Arrays.sort(intervals, (int[] t1, int[] t2) -> t1[0] - t2[0] );
        if(intervals.length == 0) return true;
        int end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= end) end = intervals[i][1];
            else return false;
        }
        
        return true;
        
    }
}