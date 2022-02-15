class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Naive Approach: sort the interval by the start time of each element by ascending order
           ^    ^       
        (1,3), (2,6) -> for every consecutive two elements, compare the end time of 1st, and start time of 2nd element 
        
        3>2 , Merge end time 1 ~ Math(3,6) 
        
        O(nlog) + O(N) = O(nlog)
        
        */
        
        Arrays.sort(intervals, (int[] t1, int[] t2)->t1[0] - t2[0]);
    
        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] mergedIntervals = new int[intervals.length][2];
        int t = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(i < intervals.length -1 && intervals[i+1][0] <= end) {
                end = Math.max(intervals[i][1], Math.max(end, intervals[i+1][1]));
            }
            
            else {
                mergedIntervals[t][0] = start;
                mergedIntervals[t++][1] = end;
                if(i == intervals.length -1) break;
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }
        return Arrays.copyOfRange(mergedIntervals, 0, t);
    }
}