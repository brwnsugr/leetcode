class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) ->a[0] - b[0]);
        int[] prevInterval = intervals[0];
        List<int[]> newIntervals = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            
            if(isOverlapping(prevInterval, currInterval)) 
                prevInterval = mergeInterval(prevInterval, currInterval);
            else {
                newIntervals.add(prevInterval);
                prevInterval = currInterval;
            }
        }
        newIntervals.add(prevInterval);
        
        int[][] answer = new int[newIntervals.size()][2];
        int idx = 0;
        for(int[] newInterval : newIntervals) {
            answer[idx][0] = newInterval[0];
            answer[idx++][1] = newInterval[1];
        }
        
        return answer;
    }
    
    private boolean isOverlapping(int[] a, int[] b) {
        return a[0] <= b[1] && a[1] >= b[0];
    }
    
    private int[] mergeInterval(int[] a, int[] b){
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}