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
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i+1][0] <= end) {
                //[1,10], [4,5], [6,7]
                // end = 10
                // end = 5, 7
                end = Math.max(intervals[i][1], Math.max(end, intervals[i+1][1]));
            }
            
            else {
                mergedIntervals[t][0] = start;
                mergedIntervals[t++][1] = end;
                
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }
        mergedIntervals[t][0] = start;
        mergedIntervals[t][1] = end;
        
        return Arrays.copyOfRange(mergedIntervals, 0, t+1);
    }
}