class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (t1, t2) ->{
            return t1[0] - t2[0];
            // else return t1[1] - t2[1];
        });
            
        // [1,3], [2,4], [2,4]
            
        //dp[i] = dp[j] + 1; // j <= i, jth index largest index not overlapping with i
        int len = intervals.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        
        for(int i = 1; i < len; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(max, dp[j]);
                    break;
                }   
            }
            dp[i] = max + 1;
        }
        
        return intervals.length - dp[len-1];
    }
    
    
    private boolean isOverlapping(int[] firstInterval, int[] secondInterval) {
        int firstEndIdx = firstInterval[1];
        int secondStartIdx = secondInterval[0];
        if(firstEndIdx > secondStartIdx) return true;
        return false;
    }
}