class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] t1, int[] t2) -> {return t1[0] - t2[0];});
        
        int startVal = intervals[0][0];
        int endVal = intervals[0][1];
        int numberOfRemoval = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart < endVal) {
                numberOfRemoval++;
                endVal = Math.min(currEnd, endVal);
            }
            else {
                endVal = currEnd;
            }
        }
        
        return numberOfRemoval;
    }
}